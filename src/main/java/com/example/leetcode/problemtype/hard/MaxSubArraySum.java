import java.io.*;
import java.lang.reflect.Type;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'evaluate' function below.
     *
     * The function is expected to return output as STRING_ARRAY.
     * The function accepts STRING api as parameter.
     */
    private static final String SEPARATOR = ":";
    public static List<String> evaluate(String api) {


        // Write your code here
        String apiResponse = getApiResponse(api);
        Type collectionType = new TypeToken<List<Group>>(){}.getType();
        Gson g = new Gson();
        List<Group> groups = g.fromJson(apiResponse, collectionType) ;
        List<String> response = new ArrayList<>();

        for(Group group : groups){
            StringBuilder sb = new StringBuilder();
            sb.append(group.getGroupName()).append(SEPARATOR);
            Map<String,Integer> orderedMap =  findOrderofEvalution(new ArrayList<>(group.getExpressions()));
            List<Expression> orderedExprs = group.getExpressions()
                    .stream()
                    .sorted((expr1,expr2) -> orderedMap.get(expr1.getName()).compareTo(orderedMap.get(expr2.getName())))
                    .collect(Collectors.toList());
            Map<String,String> exprResultMap = new HashMap<>();
            for(int i =0;i<orderedExprs.size();i++){
                String  result = evaluateExpressionToString(orderedExprs.get(i),exprResultMap);
                sb.append(orderedExprs.get(i).getName()).append(SEPARATOR).append(result);
                if( i!=orderedExprs.size()-1){
                    sb.append(SEPARATOR);
                }
            }
            response.add(sb.toString());
        }


        return response;

    }

    private static String getApiResponse(String api){
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .GET()
                .build();
        try{

            HttpResponse<String> response =  client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }catch(IOException |InterruptedException e ){
            throw new RuntimeException("Invalid URL or URL is not reachable");

        }
    }


    private static String evaluateExpressionToString(Expression expression, Map<String,String> exprResultMap){
        StringBuilder sb = new StringBuilder();
        String type = expression.getExpressionType();
        if("DIRECT".equals(type)){
            sb.append(expression.getExpression());
        }else {
            String expr = expression.getExpression();
            for(String dep : expression.getDependencies()){
                expr = expr.replace(dep, exprResultMap.get(dep));

            }
            sb.append("(").append(expr).append(")").append(" ").append("RS_EXPRESSION".equals(type) ? "RS" : "$");

        }
        exprResultMap.put(expression.getName(), sb.toString());
        return sb.toString();
    }



    private static Map<String,Integer> findOrderofEvalution(List<Expression> expressions){

        Map<String,List<String>> dep = new HashMap<>();
        List<String> result = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        Map<String,List<String>> inDegree = new HashMap<>();
        for(Expression expression : expressions){
            if(expression.getDependencies()==null || expression.getDependencies().isEmpty()) {
                inDegree.put(expression.getName(), new ArrayList<>());
                queue.add(expression.getName());
            } else{
                for(String d : expression.getDependencies()){
                    dep.putIfAbsent(d, new ArrayList<>());
                    dep.get(d).add(expression.getName());
                }
                inDegree.put(expression.getName(), expression.getDependencies());
            }
        }

        while(!queue.isEmpty())  {
            String cur = queue.remove();
            result.add(cur);
            if(dep.containsKey(cur)){
                for(String dependentExpr : dep.get(cur)){
                    inDegree.get(dependentExpr).remove(cur);
                    if(inDegree.get(dependentExpr).isEmpty()){
                        queue.add(dependentExpr);
                    }
                }
            }
        }

        if(result.size() == expressions.size()) {
            Map<String,Integer> responseMap  = new HashMap<>();
            for(int i =0 ;i< result.size();i++){
                responseMap.put(result.get(i), i);
            }
            return responseMap;
        }
        throw new RuntimeException("cyclic dependency exists in expressions dependencies");
    }


    public static class Group {
        public String groupName;
        public List<Expression> expressions = new ArrayList<>();
        public String getGroupName(){
            return groupName;
        }
        public List<Expression> getExpressions(){
            return expressions;
        }
        public void setExpressions(List<Expression> expressions){
            this.expressions = expressions;
        }
        public void setGroupName(String groupName){
            this.groupName = groupName;
        }

    }
    public static class Expression {
        public String name;
        public String expressionType;
        public String expression;
        public List<String> dependencies = new ArrayList<>();
        public String getName(){
            return name;
        }
        public String getExpressionType(){
            return expressionType;
        }
        public String getExpression(){
            return expression;
        }
        public List<String> getDependencies(){
            return dependencies;
        }
        public void getName(String name){
            this.name = name;
        }
        public void setExpressionType(String expressionType){
            this.expressionType = expressionType;
        }
        public void setExpression(String expression){
            this.expression = expression;
        }
        public void setDependencies(List<String> dependencies){
            this.dependencies = dependencies;
        }

    }

}

public class MaxSubArraySum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String api = bufferedReader.readLine();

        List<String> result = Result.evaluate(api);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

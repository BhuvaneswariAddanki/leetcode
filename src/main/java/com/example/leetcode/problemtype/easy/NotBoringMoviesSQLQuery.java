package com.example.leetcode.problemtype.easy;

/**
 * Table: Cinema
 * <p>
 * +----------------+----------+
 * | Column Name    | Type     |
 * +----------------+----------+
 * | id             | int      |
 * | movie          | varchar  |
 * | description    | varchar  |
 * | rating         | float    |
 * +----------------+----------+
 * id is the primary key (column with unique values) for this table.
 * Each row contains information about the name of a movie, its genre, and its rating.
 * rating is a 2 decimal places float in the range [0, 10]
 * <p>
 * <p>
 * <p>
 * Write a solution to report the movies with an odd-numbered ID and a description that is not "boring".
 * <p>
 * Return the result table ordered by rating in descending order.
 * <p>
 * The result format is in the following example.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * Cinema table:
 * +----+------------+-------------+--------+
 * | id | movie      | description | rating |
 * +----+------------+-------------+--------+
 * | 1  | War        | great 3D    | 8.9    |
 * | 2  | Science    | fiction     | 8.5    |
 * | 3  | irish      | boring      | 6.2    |
 * | 4  | Ice song   | Fantacy     | 8.6    |
 * | 5  | House card | Interesting | 9.1    |
 * +----+------------+-------------+--------+
 * Output:
 * +----+------------+-------------+--------+
 * | id | movie      | description | rating |
 * +----+------------+-------------+--------+
 * | 5  | House card | Interesting | 9.1    |
 * | 1  | War        | great 3D    | 8.9    |
 * +----+------------+-------------+--------+
 * Explanation:
 * We have three movies with odd-numbered IDs: 1, 3, and 5. The movie with ID = 3 is boring so we do not include it in the answer
 *
 * leetcode link : https://leetcode.com/problems/not-boring-movies/description/
 */
public class NotBoringMoviesSQLQuery {

    public String getQuery() {
        String sqlQuery = "select * from cinema where description not like '%boring%' and mod(id,2)= 1 order by rating desc;";

        String sqlQuery2 = "select * from Cinema where  id%2 =1 and description!='boring'  order by rating desc";
        return sqlQuery;
    }
}

# Write your MySQL query statement below
# SELECT customer_number, Total FROM (SELECT COUNT(order_number) AS Total, customer_number FROM Orders GROUP BY customer_number) AS table1 HAVING MAX(Total)

# SELECT MAX(test1), customer_number  FROM (SELECT COUNT(order_number) as test1, customer_number FROM Orders GROUP BY customer_number) AS table1 GROUP BY customer_number

SELECT customer_number FROM
(SELECT COUNT(order_number) as maxcount, customer_number FROM Orders GROUP BY customer_number)as table1
order by maxcount DESC limit 1; 

# financial-statement-app
# About
This application prototype implements the following functionality:
* getting financial statement using the AlphaVantage API: income statement, balance sheet, cash flow statement
* saving reports to a database
* calculation of analytical indicators for different industries based on data from the database (functionality in development)
The application is built according to the REST API concept  
# Usage
### 1. Getting company overview
```java
GET /{ticker}/overview
```  
Request parameters:
* `ticker` - company stock ticker
* `apikey` - API key from AlphaVantage
  
## 2. Getting income statement
**IMPORTANT!** In this paragraph and further in all methods of obtaining reports. If the AlphaVantage API returns the value “None” for any of the value from report, it is returned and saved to the database as a special value -1. Be careful and keep this in mind.  
The method allows you to obtain an income statement. First, the request is sent to the database. If the values are found, a response from the database is returned. If not found, a request is sent to AlphaVantage. The received data is saved to the database.
```java
GET /{ticker}/pnl
```  
Request parameters: same as paragraph 1

## 3. Getting balance sheet 
The method allows you to obtain an balance sheet
```java
GET /{ticker}/bs
```  
Request parameters: same as paragraph 1
  
# Technology stack
- Java 17  
- Spring Boot 3.2.3  
- JDBC Template  
- PostgresSQL 16  

## Disclaimer
The author does not accept responsibility for actions taken on the basis of information obtained as a result of using this program. The author does not represent that the information or opinions provided are correct or complete. The information presented shouldn't be used as the sole guide for making investment decisions. Doesn't individual investment advice.
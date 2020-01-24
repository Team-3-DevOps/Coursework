package com.napier.coursework;

// main application for world population reports

import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App
{      /**
 * Connection to MySQL database.
 */
private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "Team-3-DevOps-CW");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public Integer getINTInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            int i = Integer.parseInt(s);
            return i;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get input");
            return null;
        }
    }

    public String getSTRInput() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            System.out.println(s);
            return s;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get inputs");
            return null;
        }
    }

    /**
     * Gets all the countries in the world by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getAllCountries()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  " +
                            " FROM country " + "ORDER BY country.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Gets all the countries in a continent by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getAllCountriesInContinent(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital FROM country WHERE country.Continent='"+str+"' ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Gets all the countries in a region by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getAllCountriesInRegion(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  FROM country WHERE country.Region='"+str+"' ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets top N populated countries in the world by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getTopPopCountriesInWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  FROM country ORDER BY country.Population DESC LIMIT " + num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    /**
     * Gets all the countries in a continent by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getAllCountriesInContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  "
                            + "FROM country "
                            + "WHERE country.Continent = 'Asia' "
                            + "ORDER BY country.Population DESC ";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets top N populated countries in a continent by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getTopPopCountriesInContinent(String str, Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  "
                            + "FROM country "
                            + "WHERE country.Continent ='"+str+"' ORDER BY country.Population DESC LIMIT " + num;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    /**
     * Gets top N populated countries in a region by largest population to smallest.
     * @return A list of all countries and population, or null if there is an error.
     */
    public ArrayList<Country> getTopPopCountriesInRegion(String str, Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital  "
                            + "FROM country "
                            + "WHERE country.Region = '"+str+"' ORDER BY country.Population DESC LIMIT "+ num;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country ctry = new Country();
                ctry.setCode(rset.getString("country.code"));
                ctry.setName(rset.getString("country.name"));
                ctry.setContinent(rset.getString("country.continent"));
                ctry.setRegion(rset.getString("country.region"));
                ctry.setPopulation(rset.getInt("country.population"));
                ctry.setCapital(rset.getInt("country.capital"));
                countries.add(ctry);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }


    /**
     * Gets all the current cities in the world ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCities()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM `city` ORDER BY `Population` DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Gets all the current cities in the continent ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCitiesInContinent(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Continent='"+str+"' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();

            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);


            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    /**
     * Gets all the current cities in the region ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCitiesInRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Region='Caribbean' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {

                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    /**
     * Gets all the current cities in the country ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCitiesInCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population, country.Continent FROM city INNER JOIN country ON city.CountryCode = country.Code WHERE country.Name='Myanmar' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {

                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Gets all the current cities in the district ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllCitiesInDistrict()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM city WHERE city.District = 'Kabol' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Gets all the current cities in the district ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllTopCities(Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM city ORDER BY Population DESC LIMIT " + num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Gets all the current cities in the district ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllTopCitiesInContinent(Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM city ORDER BY Population DESC LIMIT " + num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Gets all the current cities in the district ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllTopCitiesInRegion(Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM city ORDER BY Population DESC LIMIT " + num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Gets all the current cities in the district ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllTopCitiesInCountry(Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM city ORDER BY Population DESC LIMIT " + num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Gets all the current cities in the district ordering by population
     * @return A list of all city names, country-code, district and their population, or null if there is an error.
     */
    public ArrayList<City> getAllTopCitiesInDistrict(Integer num)
    {
        try
        {

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT * FROM city ORDER BY Population DESC LIMIT " + num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> city = new ArrayList<City>();
            while (rset.next())
            {
                City cty = new City();
                cty.setID(rset.getInt("city.ID"));
                cty.setName(rset.getString("city.Name"));
                cty.setCountryCode(rset.getString("city.CountryCode"));
                cty.setDistrict(rset.getString("city.District"));
                cty.setPopulation(rset.getInt("city.Population"));
                city.add(cty);
            }
            return city;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    /**
     * Gets all the capital cities in the world ordering by population
     * @return A list of all capital city names, country name and city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getAllCapitalCities()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM `city` INNER JOIN country ON country.Capital=city.ID ORDER BY `Population` DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Gets all the capital cities in the world ordering by population
     * @return A list of all capital city names, country name and city  population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getTopPopCapitalCities(Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM `city` INNER JOIN country ON country.Capital=city.ID ORDER BY `Population` DESC LIMIT "+ num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Gets all the current capital cities in the continent ordering by population
     * @return A list of all capital city names, country name and city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getAllCapCitiesInContinent(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM city INNER JOIN country ON country.Capital=city.ID WHERE country.Continent='"+str+"' ORDER BY city.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Gets all the current capital cities in the continent ordering by population
     * @return A list of all capital city names, country name and city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getTopPopCapCitiesInContinent(String str, Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name, city.Population FROM city INNER JOIN country ON country.Capital=city.ID WHERE country.Continent='"+str+"' ORDER BY city.Population DESC LIMIT "+ num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }


    /**
     * Gets all the current capital cities in the region ordering by population
     * @return A list of all capital city names, country name, city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getAllCapCitiesInRegion(String str)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  city.Name, country.Name, city.Population  FROM city INNER JOIN country ON country.Capital=city.ID WHERE country.Region='"+str+"' ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Gets all the current capital cities in the region ordering by population
     * @return A list of all city names, country name, city population, or null if there is an error.
     */
    public ArrayList<CapitalCity> getTopPopCapCitiesInRegion(String str, Integer num)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  city.Name, country.Name, city.Population  FROM city INNER JOIN country ON country.Capital=city.ID WHERE country.Region='"+str+"' ORDER BY Population DESC LIMIT "+ num;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<CapitalCity> Capcity = new ArrayList<CapitalCity>();
            while (rset.next())
            {
                CapitalCity capcty = new CapitalCity();

                capcty.setName(rset.getString("city.Name"));
                capcty.setCountry(rset.getString("country.Name"));
                capcty.setPopulation(rset.getInt("city.Population"));
                Capcity.add(capcty);
            }
            return Capcity;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    /**
     * Prints a list of capital cities.
     * @param Capcity The list of capital cities to print.
     */
    public void printCapitalCityInfo(ArrayList<CapitalCity> Capcity)
    {
        // Print header
        System.out.println("Here is a report of capital cities by descending their populations");
        //System.out.println(String.format("%-20s %-50s %-20s %-50s %-50s", "City ID", "Name", "Country Code", "District", "Population"));
        // Loop over all employees in the list
        for (CapitalCity capcty : Capcity)
        {
//            String cty_stringta =
//                    String.format("%-20s %-50s %-20s %-50s %-50s",
//                            city.Name, country.Name, city.Population);
            System.out.println(capcty);
        }
    }

    /**
     * Prints a list of countries.
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println("Here is a report of countries by descending their populations");
        //System.out.println(String.format("%-10s %-60s %-20s %-30s %-15s %-10s", "Code", "Country", "Continent", "Region", "Population", "Capitals"));
        // Loop over all countries in the list
        for (Country ctry : countries)
        {
            //String ctry_string =
            //  String.format("%-10s %-60s %-20s %-30s %-15s %-10s" , ctry.code, ctry.name, ctry.continent, ctry.region, ctry.population, ctry.capital);
            System.out.println(ctry);
        }
    }
    /**
     * Prints a list of cities.
     * @param city The list of cities to print.
     */
    public void printCityInfo(ArrayList<City> city)
    {
        // Print header
        System.out.println("Here is a report of cities by descending their populations");
        //System.out.println(String.format("%-20s %-50s %-20s %-50s %-50s", "City ID", "Name", "Country Code", "District", "Population"));
        // Loop over all employees in the list
        for (City cty : city)
        {
//            String cty_string =
//                    String.format("%-20s %-50s %-20s %-50s %-50s",
//                            cty.ID, cty.Name, cty.CountryCode, cty.District, cty.Population);
            System.out.println(cty);
        }
    }


    public static void main(String[] args)
    {
        try {
            // Create new Application
            App a = new App();

            // Connect to database
            a.connect();

            do {
                System.out.println("-+-+-+-+-+-+-+-+-+-+-+");
                System.out.println("-+(WORLD POPULATION)+-");
                System.out.println("= Reports are ordered by largest population to smallest =");
                System.out.println("1. COUNTRY REPORTS +-");
                System.out.println("2. CITY REPORTS +-");
                System.out.println("3. CAPITAL CITY REPORTS +-");
                Integer selector1 = a.getINTInput();
                if(selector1 == 1)
                {
                    try{
                        System.out.println("1. Rank all countries in the world");
                        System.out.println("2. Rank all countries in a continent");
                        System.out.println("3. Rank all countries in a region");
                        System.out.println("4. Rank top <N> countries in the world");
                        System.out.println("5. Rank top <N> countries in a continent");
                        System.out.println("6. Rank top <N> countires in a region");
                        Integer selector2 = a.getINTInput();

                        if(selector2 == 1)
                        {
                            // Extract countries in the world by descending population
                            ArrayList<Country> countries = a.getAllCountries();
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else if(selector2 == 2)
                        {
                            System.out.println("= ENTER a continent name -  ");
                            String str = a.getSTRInput();
                            // Extract countries in the continent by descending population
                            ArrayList<Country> countries = a.getAllCountriesInContinent(str);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else if(selector2 == 3)
                        {
                            System.out.println("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getAllCountriesInRegion(str);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else if(selector2 == 4)
                        {
                            System.out.println("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getTopPopCountriesInWorld(num);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else if(selector2 == 5)
                        {
                            System.out.println("= ENTER a continent name - ");
                            String str = a.getSTRInput();
                            System.out.println("= ENTER a number to limit rankings");
                            Integer selector2 = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getTopPopCountriesInContinent(str, num);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                        else{
                            System.out.println("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            System.out.println("= ENTER a number to limit rankings");
                            Integer selector2 = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getTopPopCountriesInRegion(str, num);
                            // Print format function for countries
                            a.printCountries(countries);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }
                else if (selector1 == 2)
                {
                    try
                    {
                        System.out.println("1. Rank all cities in the world");
                        System.out.println("2. Rank all cities in a continent");
                        System.out.println("3. Rank all cities in a region");
                        System.out.println("4. Rank all cities in a country");
                        System.out.println("5. Rank all cities in a district");
                        System.out.println("6. Rank top <N> countries in the world");
                        System.out.println("7. Rank top <N> countries in a continent");
                        System.out.println("8. Rank top <N> countires in a region");
                        System.out.println("9. Rank top <N> countires in a country");
                        System.out.println("10. Rank top <N> countires in a district");
                        Integer selector2 = a.getINTInput();
                        if (selector2 == 1)
                        {
                            // Extract cities in the world by descending population
                            ArrayList<City> city = a.getAllCities();
                            // Print format function for cities
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 2)
                        {
                            System.out.println("= ENTER a continent name -  ");
                            String str = a.getSTRInput();
                            // Extract cities in continent by descending population
                            ArrayList<City> city = a.getAllCitiesInContinent(str);
                            // Print format function for cities
                            a.printCityInfo(city);

                        }
                        else if (selector2 == 3)
                        {
                            System.out.println("= ENTER a region name -  ");
                            String str = a.getSTRInput();
                            // Extract cities in continent by descending population
                            ArrayList<City> city = a.getAllCitiesInRegion(str);
                            // Print format function for cities
                            a.printCityInfo(city);

                        }
                        else if (selector2 == 4)
                        {
                            System.out.println("= ENTER a country name -  ");
                            String str = a.getSTRInput();
                            // Extract cities in continent by descending population
                            ArrayList<City> city = a.getAllCitiesInCountry(str);
                            // Print format function for cities
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 5)
                        {
                            System.out.println("= ENTER a district name -  ");
                            String str = a.getSTRInput();
                            // Extract cities in continent by descending population
                            ArrayList<City> city = a.getAllCitiesInDistrict(str);
                            // Print format function for cities
                            a.printCityInfo(city);
                        }
                        else if (selector2 == 6)
                        {
                            System.out.println("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getAllTopCities(num);
                            // Print format function for countries
                            a.printCountries(city);
                        }
                        else if (selector2 == 7)
                        {
                            System.out.println("= ENTER a continent name - ");
                            String str = a.getSTRInput();
                            System.out.println("= ENTER a number to limit rankings");
                            Integer selector2 = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getAllTopCitiesInContinent(str, num);
                            // Print format function for countries
                            a.printCountries(city);
                        }
                        else if (selector2 == 8)
                        {
                            System.out.println("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            System.out.println("= ENTER a number to limit rankings");
                            Integer selector2 = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getAllTopCitiesInRegion(str, num);
                            // Print format function for countries
                            a.printCountries(city);
                        }
                        else if (selector2 == 9)
                        {
                            System.out.println("= ENTER a country name - ");
                            String str = a.getSTRInput();
                            System.out.println("= ENTER a number to limit rankings");
                            Integer selector2 = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getAllTopCitiesInCountry(str, num);
                            // Print format function for countries
                            a.printCountries(city);
                        }
                        else
                        {
                            System.out.println("= ENTER a district name - ");
                            String str = a.getSTRInput();
                            System.out.println("= ENTER a number to limit rankings");
                            Integer selector2 = a.getINTInput();
                            // Extract countries in the region by descending population
                            ArrayList<Country> countries = a.getAllTopCitiesInDistrict(str, num);
                            // Print format function for countries
                            a.printCountries(city);
                        }


                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }
                else
                {
                    try{
                        System.out.println("1. Rank all capital cities in the world");
                        System.out.println("2. Rank all capital cities in a continent");
                        System.out.println("3. Rank all capital cities in a region");
                        System.out.println("4. Rank top <N> capital cities in the world");
                        System.out.println("5. Rank top <N> capital cities in a continent");
                        System.out.println("6. Rank top <N> capital cities in a region");
                        Integer selector2 = a.getINTInput();
                        if(selector2 == 1)
                        {
                            // Extract captial cities in the world by descending population
                            ArrayList<CapitalCity> Capcity = a.getAllCapitalCities();
                            // Print format function for capital cities
                            a.printCapitalCityInfo(Capcity);
                        }
                        else if(selector2 == 2)
                        {
                            System.out.println("= ENTER a continent name -  ");
                            String str = a.getSTRInput();
                            // Extract capital cities in the continent by descending population
                            ArrayList<CaptialCity> Capcity = a.getAllCapCitiesInContinent(str);
                            // Print format function for capital cities
                            a.printCountries(Capcity);
                        }
                        else if(selector2 == 3)
                        {
                            System.out.println("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            // Extract capital citeis in the region by descending population
                            ArrayList<CapitalCity> Capcity = a.getAllCapCitiesInRegion(str);
                            // Print format function for capital cities
                            a.printCountries(Capcity);
                        }
                        else if(selector2 == 4)
                        {
                            System.out.println("= ENTER a number to limit rankings - ");
                            Integer num = a.getINTInput();
                            // Extract capital cities in the region by descending population
                            ArrayList<CapitalCity> Capcity = a.getTopPopCapitalCities(num);
                            // Print format function for capital cities
                            a.printCountries(Capcity);
                        }
                        else if(selector2 == 5)
                        {
                            System.out.println("= ENTER a continent name - ");
                            String str = a.getSTRInput();
                            System.out.println("= ENTER a number to limit rankings");
                            Integer selector2 = a.getINTInput();
                            // Extract capital cities in the region by descending population
                            ArrayList<CapitalCity> Capcity = a.getTopPopCapCitiesInContinent(str, num);
                            // Print format function for capital cities
                            a.printCountries(Capcity);
                        }
                        else{
                            System.out.println("= ENTER a region name - ");
                            String str = a.getSTRInput();
                            System.out.println("= ENTER a number to limit rankings");
                            Integer selector2 = a.getINTInput();
                            // Extract capital cities in the region by descending population
                            ArrayList<CapitalCity> Capcity = a.getTopPopCountriesInRegion(str, num);
                            // Print format function for capital cities
                            a.printCountries(Capcity);
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println("Error");
                    }
                }

                System.out.printIn("- Do you want to continue (y or n)?");
                char ans = a.getSTRInput();
            } while (ans == y)



            // Disconnect from database
            System.out.printIn("- Disconnecting database ---> ")
            a.disconnect();

        }
        catch(Exception e)
        {
            System.out.println("Main function failure!");
        }






    }

}
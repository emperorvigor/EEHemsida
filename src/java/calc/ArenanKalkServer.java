/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calc;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Widar
 */

//------------- OBS! Under konstrukition! ----------------
public class ArenanKalkServer {
    Connection con;
    Statement queryCaller;
    ResultSet result;
    PreparedStatement preparedStm;
    MysqlDataSource ds;
    List<Integer> pointList;
    
    ArenanKalkylator arKalk;
    
    public ArenanKalkServer(List<Integer> list){
        pointList = list;
        ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setPort(3306);
        ds.setDatabaseName("arenancalc");
        serverConnect();
    }
    
    private void serverConnect (){
            con = null;
            String userName = "arenancalc", pw = "testar";
            try {
                            con = ds.getConnection(userName, pw);
                    } catch (SQLException e) {
                            System.out.println("Could not connect :( - " + e.getMessage());
                    }
            
            System.out.println("I'd be damn, you're connected!");

            queryCaller = null;
            try {
                    queryCaller = con.createStatement();
            } catch (SQLException e) {
                    System.out.println("Could not create statement! " + e.getMessage());
                    try {
                            con.close();
                    } catch (SQLException e1) {
                            System.out.println("Could not close connection! " + e1.getMessage());
                    }
                    return;
            }

            System.out.println("Create statement successful!");

            result = null;
    }    
    
    public void calcResult () {
        double ras = 1, //----- OBS! ÄNDRA TILL ATT BERO PÅ INPUT SENARE!!!!! OBS!
                
            ung = 0,
            vuxen = 0,
            medel = 0,
            gammal = 0,
                
            totUng = 0,
            totVux = 0,
            totMed = 0,
            totGam = 0,
                
            totpUng = 0,
            totpVux = 0,
            totpMed = 0,
            totpGam = 0;
        
        String text = null,
               totText = null,
               output = null;
        
        int index;
        
         try {
			result = queryCaller.executeQuery("SELECT * FROM arenancalc.agevalues WHERE ras=" + ras +";");
			result.afterLast();

	} catch (SQLException e) {
			System.out.println("Failure in selecting all from DB-function.");
			e.printStackTrace();
	}
       
         try {
             index = 14;
             while(result.previous()){
                ung = pointList.get(index)*result.getDouble("ung");
                vuxen = pointList.get(index)*result.getDouble("vuxen");
                medel = pointList.get(index)*result.getDouble("medel");
                gammal = pointList.get(index)*result.getDouble("gammal");
                
                totUng += ung;
                totVux += vuxen; 
                totMed += medel;
                totGam += gammal;
                
                totpUng += ung;
                totpVux += vuxen;
                totpMed += medel;
                totpGam += gammal;
            
                text =  "<tr>" + System.lineSeparator() +
                        "   <td>" + Double.toString(ung) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(vuxen) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(medel) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(gammal) + "</td>" + System.lineSeparator() +
                        "</tr>";
                output = text + totText;
             
                if(index == 7 || index == 4 || index == 1) {
                    output = "<tr>" + System.lineSeparator() +
                        "   <td>" + Double.toString(totUng) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(totVux) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(totMed) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(totGam) + "</td>" + System.lineSeparator() +
                        "</tr>" + output;
                    totUng = 0;
                    totVux = 0;
                    totMed = 0;
                    totGam = 0;   
                }
                index--;
             }
             
         } catch (SQLException e) {
			System.out.println("Failure in getClassification-function.");
			e.printStackTrace();
	}
         System.out.println(output);
         arKalk.setCalcResult("<table>" + output + "<tr>" + System.lineSeparator() +
                        "   <td>" + Double.toString(totpUng) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(totpVux) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(totpMed) + "</td>" + System.lineSeparator() +
                        "   <td>" + Double.toString(totpGam) + "</td>" + System.lineSeparator() +
                        "</tr>" + System.lineSeparator() + "</table>");
    }
}

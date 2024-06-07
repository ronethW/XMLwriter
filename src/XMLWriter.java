// Java Program to Write XML Using DOM Parser

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class XMLWriter {
    public static void main(String[] args) throws Exception {

        List<ArrayList<String>> fileData = new ArrayList<>();
        try {
            File myObj = new File("log.txt");
            Scanner myReader = new Scanner(myObj);
            int groupNo = 1;
            ArrayList<String> temp = new ArrayList<>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (!data.isBlank()){
                    String firstChar = data.substring(0, 1);
                    if (Integer.parseInt(firstChar) == groupNo) {
                        temp.add(data.substring(2));
                    } else {
                        fileData.add(temp);
                        temp = new ArrayList<>();
                        groupNo++;
                        temp.add(data.substring(2));
                    }
                }

            }
            fileData.add(temp);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the text file");
            e.printStackTrace();
        }
        System.out.println(fileData);

        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a new Document
        Document document = builder.newDocument();

        // Create root element
        Element root = document.createElement("dependencies");
        document.appendChild(root);

        // Create book elements and add text content
        for (ArrayList<String> i :fileData){
            Element book1 = document.createElement("dependency");
            for (String j:i){
                System.out.println(j);
                String[] t = j.split("=");
                Element book2 = document.createElement(t[0].trim());
                book2.appendChild(document.createTextNode( t[1]));
                book1.appendChild(book2);
            }
            root.appendChild(book1);
        }


        // Write to XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);


        // Specify your local file path
        StreamResult result = new StreamResult(new File("dependencies.xml"));
        transformer.transform(source, result);

        System.out.println("XML file created successfully!");
    }
}

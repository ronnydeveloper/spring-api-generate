package generator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class GeneratorService {

    public static String packageImport(String root, String model) {
        String repositoryPackages = root + ".service;";
        StringBuilder sbx = new StringBuilder();
        sbx.append("package " + repositoryPackages);
        sbx.append("\n");
        sbx.append("\n");
        sbx.append("import id.co.ptap.circleaf.core.dto.ApiResponse;");
        sbx.append("\n");
        sbx.append("import " + root + ".model." + model + ";");
        sbx.append("\n");
        sbx.append("\n");
        sbx.append("import javax.persistence.EntityNotFoundException;");
        sbx.append("\n");
        sbx.append("import java.util.List;");
        sbx.append("\n");
        sbx.append("\n");
        return sbx.toString();
    }

    public static File className(String packages, String fileName) throws IOException {
        String locationFile = packages.replaceAll("\\.","\\/") + "/" + fileName;
        String path = Paths.get("").toAbsolutePath().toString() + "\\src\\main\\java\\" + locationFile;
//        String path = "C:\\ProjekLaporan\\" + fileName;
        System.out.println("Location File : " + path);
        File file = new File(path);
        GeneratorModel.delete(file);

        if (file.createNewFile()){
            System.out.println("File is created!");
        }else{
            System.out.println("File already exists.");
        }
        return file;
    }

    public static String createService(String root, Node nNode) {

        StringBuilder sb = new StringBuilder();
        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode;

            StringBuilder sbimp = new StringBuilder(packageImport(root, eElement.getAttribute("name")));
            sb.append("public interface " + eElement.getAttribute("name") + "Service {");
            sb.append("\n");
            sb.append("\n");

            NodeList nColumnList = nNode.getChildNodes();

            for (int i = 0; i < nColumnList.getLength(); i++) {
                Node nNodeCol = nColumnList.item(i);

                System.out.println("\nCurrent Element :" + nNodeCol.getNodeName());
                if (nNodeCol.getNodeType() == Node.ELEMENT_NODE) {

                    if (nNodeCol.getNodeName().equals("column")) {
                        Element eElementCol = (Element) nNodeCol;

                        if (eElementCol.getAttribute("primary").equalsIgnoreCase("true")) {

                            sb.append("    "+ eElement.getAttribute("name") + " createOrUpdate"+eElement.getAttribute("name")+"("+eElement.getAttribute("name")+" "+GeneratorModel.lop(eElement.getAttribute("name"))+");");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    void delete"+ eElement.getAttribute("name") + "ById(" + eElementCol.getAttribute("type") + " " + GeneratorModel.lop(eElementCol.getAttribute("name")) + ") throws EntityNotFoundException;");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    "+ eElement.getAttribute("name") + " get"+eElement.getAttribute("name")+ "ById(" + eElementCol.getAttribute("type") + " " + GeneratorModel.lop(eElementCol.getAttribute("name")) + ") throws EntityNotFoundException;");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    List<"+ eElement.getAttribute("name") +"> findAll();");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    ApiResponse<List<"+ eElement.getAttribute("name") +">> doView();");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    ApiResponse doAdd("+ eElement.getAttribute("name") +" "+ GeneratorModel.lop(eElement.getAttribute("name")) +");");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    ApiResponse doEdit("+ eElement.getAttribute("name") +" "+ GeneratorModel.lop(eElement.getAttribute("name")) +");");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    ApiResponse doDelete(List<"+ eElement.getAttribute("name") +"> "+ GeneratorModel.lop(eElement.getAttribute("name")) +"List);");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    ApiResponse doPreview("+ eElement.getAttribute("name") +" "+ GeneratorModel.lop(eElement.getAttribute("name")) +");");
                            sb.append("\n");
                            sb.append("\n");
                        }
                    }
                }
            }

            sb.append("} ");
            return sbimp.toString() + sb.toString();
        }

        return "";
    }

    public static void createJavaFile(String data, File file) throws IOException {
        FileOutputStream out = new FileOutputStream(file);
        out.write(data.getBytes());
        out.close();
    }

    public static void generateService(Document doc) throws IOException {
        String servicePackage = GeneratorRepository.getRootElement(doc) + ".service";
        List<Node> childNodes = GeneratorModel.getChildNodes(doc.getElementsByTagName("service").item(0), "entity");

        for (Node item : childNodes) {
            Element el = (Element) item;
            String data = createService(GeneratorRepository.getRootElement(doc), item);
            createJavaFile(data, className(servicePackage, el.getAttribute("name") + "Service.java"));
        }
    }
}

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

public class GeneratorServiceImpl {

    public static String packageImport(String root, String model) {
        String repositoryPackages = root + ".service.impl;";
        StringBuilder sbx = new StringBuilder();
        sbx.append("package " + repositoryPackages);
        sbx.append("\n");
        sbx.append("\n");
        sbx.append("import id.co.ptap.circleaf.core.dto.ApiResponse;");
        sbx.append("\n");
        sbx.append("import id.co.ptap.circleaf.core.enums.ResponseCode;");
        sbx.append("\n");
        sbx.append("import " + root + ".model." + model + ";");
        sbx.append("\n");
        sbx.append("import " + root + ".repository." + model + "Repo;");
        sbx.append("\n");
        sbx.append("import " + root + ".service." + model + "Service;");
        sbx.append("\n");
        sbx.append("import org.apache.log4j.Logger;");
        sbx.append("\n");
        sbx.append("import org.modelmapper.ModelMapper;");
        sbx.append("\n");
        sbx.append("import org.springframework.beans.factory.annotation.Autowired;");
        sbx.append("\n");
        sbx.append("import org.springframework.stereotype.Service;").append("\n");
        sbx.append("\n");
        sbx.append("import javax.persistence.EntityExistsException;");
        sbx.append("\n");
        sbx.append("import javax.persistence.EntityNotFoundException;");
        sbx.append("\n");
        sbx.append("import java.util.Optional;");
        sbx.append("\n");
        sbx.append("import java.util.stream.Collectors;");
        sbx.append("\n");
        sbx.append("import java.util.stream.StreamSupport;");
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

    public static String createServiceImpl(String root, Node nNode) {

        StringBuilder sb = new StringBuilder();
        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;

            StringBuilder sbimp = new StringBuilder(packageImport(root, eElement.getAttribute("name")));
            sb.append("@Service(\""+ GeneratorModel.lop(eElement.getAttribute("name")) +"Service\")");
            sb.append("\n");
            sb.append("public class " + eElement.getAttribute("name") + "ServiceImpl implements " + eElement.getAttribute("name") + "Service {").append("\n");
            sb.append("\n");
            sb.append("    static final Logger logger = Logger.getLogger(" + eElement.getAttribute("name") + "ServiceImpl.class);").append("\n\n");
            sb.append("    @Autowired").append("\n");
            sb.append("    private "+ eElement.getAttribute("name") +"Repo "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository;").append("\n\n");

            NodeList nColumnList = nNode.getChildNodes();

            for (int i = 0; i < nColumnList.getLength(); i++) {
                Node nNodeCol = nColumnList.item(i);

                System.out.println("\nCurrent Element :" + nNodeCol.getNodeName());
                if (nNodeCol.getNodeType() == Node.ELEMENT_NODE) {

                    if (nNodeCol.getNodeName().equals("column")) {
                        Element eElementCol = (Element) nNodeCol;

                        if (eElementCol.getAttribute("primary").equalsIgnoreCase("true")) {

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public "+ eElement.getAttribute("name") + " createOrUpdate"+eElement.getAttribute("name")+"("+eElement.getAttribute("name")+" "+GeneratorModel.lop(eElement.getAttribute("name"))+") {");
                            sb.append("\n");
                            sb.append("         Optional<"+ eElement.getAttribute("name") + "> "+ GeneratorModel.lop(eElement.getAttribute("name")) + "Optional = "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository.findById("+ GeneratorModel.lop(eElement.getAttribute("name")) +".get"+GeneratorModel.cap(eElementCol.getAttribute("name"))+"());");
                            sb.append("\n");
                            sb.append("         if("+ GeneratorModel.lop(eElement.getAttribute("name")) + "Optional.isPresent())");
                            sb.append("\n");
                            sb.append("         {");
                            sb.append("\n");
                            sb.append("             ModelMapper modelMapper = new ModelMapper();");
                            sb.append("\n");
                            sb.append("             "+ eElement.getAttribute("name") + " new"+ eElement.getAttribute("name") + " = modelMapper.map("+ GeneratorModel.lop(eElement.getAttribute("name")) + ", "+ eElement.getAttribute("name") + ".class);");
                            sb.append("\n");
                            sb.append("             new"+ eElement.getAttribute("name") + " = "+ GeneratorModel.lop(eElement.getAttribute("name")) + "Repository.save(new"+ eElement.getAttribute("name") +");");
                            sb.append("\n");
                            sb.append("             return new"+ eElement.getAttribute("name") + ";");
                            sb.append("\n");
                            sb.append("         } else {");
                            sb.append("\n");
                            sb.append("             "+ GeneratorModel.lop(eElement.getAttribute("name")) + " = "+ GeneratorModel.lop(eElement.getAttribute("name")) + "Repository.save(" + GeneratorModel.lop(eElement.getAttribute("name")) + ");");
                            sb.append("\n");
                            sb.append("             return "+ GeneratorModel.lop(eElement.getAttribute("name")) + ";");
                            sb.append("\n");
                            sb.append("         }");
                            sb.append("\n");
                            sb.append("    }");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public void delete"+ eElement.getAttribute("name") + "ById(" + eElementCol.getAttribute("type") + " " + GeneratorModel.lop(eElementCol.getAttribute("name")) + ") throws EntityNotFoundException {");
                            sb.append("\n");
                            sb.append("         Optional<"+ eElement.getAttribute("name") + "> "+ GeneratorModel.lop(eElement.getAttribute("name")) + "Optional = "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository.findById("+ GeneratorModel.lop(eElementCol.getAttribute("name")) + ");");
                            sb.append("\n");
                            sb.append("         if("+ GeneratorModel.lop(eElement.getAttribute("name")) + "Optional.isPresent())");
                            sb.append("\n");
                            sb.append("         {");
                            sb.append("\n");
                            sb.append("            "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository.deleteById("+GeneratorModel.lop(eElementCol.getAttribute("name"))+");");
                            sb.append("\n");
                            sb.append("         } else {");
                            sb.append("\n");
                            sb.append("            throw new EntityNotFoundException(\"No "+ eElement.getAttribute("name") +" record exist for given id\");");
                            sb.append("\n");
                            sb.append("         }");
                            sb.append("\n");
                            sb.append("    }");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public "+ eElement.getAttribute("name") + " get"+eElement.getAttribute("name")+ "ById(" + eElementCol.getAttribute("type") + " " + eElementCol.getAttribute("name") + ") throws EntityNotFoundException {");
                            sb.append("\n");
                            sb.append("         Optional<"+ eElement.getAttribute("name") + "> "+ GeneratorModel.lop(eElement.getAttribute("name")) + "Optional = "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository.findById("+ eElementCol.getAttribute("name") + ");");
                            sb.append("\n");
                            sb.append("         if("+ GeneratorModel.lop(eElement.getAttribute("name")) + "Optional.isPresent())");
                            sb.append("\n");
                            sb.append("         {");
                            sb.append("\n");
                            sb.append("            return "+ GeneratorModel.lop(eElement.getAttribute("name")) + "Optional.get();");
                            sb.append("\n");
                            sb.append("         } else {");
                            sb.append("\n");
                            sb.append("            throw new EntityNotFoundException(\"No "+ eElement.getAttribute("name") + " record exist for given id\");");
                            sb.append("\n");
                            sb.append("         }");
                            sb.append("\n");
                            sb.append("    }");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public List<"+ eElement.getAttribute("name") +"> findAll() {");
                            sb.append("\n");
                            sb.append("        List<"+ eElement.getAttribute("name") +"> list = StreamSupport");
                            sb.append("\n");
                            sb.append("                .stream("+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository.findAll().spliterator(), false)");
                            sb.append("\n");
                            sb.append("                .collect(Collectors.toList());");
                            sb.append("\n");
                            sb.append("        return list;");
                            sb.append("\n");
                            sb.append("    }");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public ApiResponse<List<"+ eElement.getAttribute("name") +">> doView() {");
                            sb.append("\n");
                            sb.append("         ApiResponse apiResponse = new ApiResponse();");
                            sb.append("\n");
                            sb.append("         try {");
                            sb.append("\n");
                            sb.append("             List<"+ eElement.getAttribute("name") +"> "+ GeneratorModel.lop(eElement.getAttribute("name")) + "List = this.findAll();");
                            sb.append("\n");
                            sb.append("             apiResponse.setData("+ GeneratorModel.lop(eElement.getAttribute("name")) + "List);");
                            sb.append("\n");
                            sb.append("         } catch (Exception var3) {");
                            sb.append("\n");
                            sb.append("             logger.error(var3);");
                            sb.append("\n");
                            sb.append("             apiResponse.setResponseCodeEnum(ResponseCode._999);");
                            sb.append("\n");
                            sb.append("             apiResponse.setResponseMessage(var3.getMessage());");
                            sb.append("\n");
                            sb.append("         }");
                            sb.append("\n");
                            sb.append("         return apiResponse;");
                            sb.append("\n");
                            sb.append("    }");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public ApiResponse doAdd("+ eElement.getAttribute("name") +" "+ GeneratorModel.lop(eElement.getAttribute("name")) +") {");
                            sb.append("\n");
                            sb.append("         ApiResponse apiResponse = new ApiResponse();");
                            sb.append("\n");
                            sb.append("         try {");
                            sb.append("\n");
                            sb.append("            if ("+GeneratorModel.lop(eElement.getAttribute("name"))+" == null) {");
                            sb.append("\n");
                            sb.append("                throw new NullPointerException(\""+eElement.getAttribute("name")+" cannot be null\");");
                            sb.append("\n");
                            sb.append("            }");
                            sb.append("\n");
                            sb.append("            else {");
                            sb.append("\n");
                            sb.append("                long max = 0;");
                            sb.append("\n");
                            sb.append("                long count = "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository.count();");
                            sb.append("\n");
                            sb.append("                if(count < 1) {");
                            sb.append("\n");
                            sb.append("                    max = 1;");
                            sb.append("\n");
                            sb.append("                } else {");
                            sb.append("\n");
                            sb.append("                    max = "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository.max();");
                            sb.append("\n");
                            sb.append("                }");
                            sb.append("\n");
                            sb.append("                "+GeneratorModel.lop(eElement.getAttribute("name"))+".set"+GeneratorModel.cap(eElementCol.getAttribute("name"))+"(max);");
                            sb.append("\n");
                            sb.append("            }");
                            sb.append("\n");
                            sb.append("            Optional<"+eElement.getAttribute("name")+"> "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Optional = "+ GeneratorModel.lop(eElement.getAttribute("name")) +"Repository.findById("+GeneratorModel.lop(eElement.getAttribute("name"))+".get"+GeneratorModel.cap(eElementCol.getAttribute("name"))+"());");
                            sb.append("\n");
                            sb.append("            if("+ GeneratorModel.lop(eElement.getAttribute("name")) +"Optional.isPresent()) {");
                            sb.append("\n");
                            sb.append("                throw new EntityExistsException(\"There is a "+ eElement.getAttribute("name") +" record exist for given " + eElementCol.getAttribute("name") + "\");");
                            sb.append("\n");
                            sb.append("            } else {");
                            sb.append("\n");
                            sb.append("                this.createOrUpdate"+eElement.getAttribute("name")+"("+GeneratorModel.lop(eElement.getAttribute("name"))+");");
                            sb.append("\n");
                            sb.append("            }");
                            sb.append("\n");
                            sb.append("        } catch (Exception var5) {");
                            sb.append("\n");
                            sb.append("            logger.error(var5);");
                            sb.append("\n");
                            sb.append("            apiResponse.setResponseCodeEnum(ResponseCode._999);");
                            sb.append("\n");
                            sb.append("            apiResponse.setResponseMessage(var5.getMessage());");
                            sb.append("\n");
                            sb.append("        }");
                            sb.append("\n");
                            sb.append("        return apiResponse;");
                            sb.append("\n");
                            sb.append("    }");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public ApiResponse doEdit("+ eElement.getAttribute("name") +" "+ GeneratorModel.lop(eElement.getAttribute("name")) +") {");
                            sb.append("\n");
                            sb.append("        ApiResponse apiResponse = new ApiResponse();");
                            sb.append("\n");
                            sb.append("        try {");
                            sb.append("\n");
                            sb.append("            if (" + GeneratorModel.lop(eElement.getAttribute("name")) + " == null) {");
                            sb.append("\n");
                            sb.append("                throw new NullPointerException(\"" + GeneratorModel.lop(eElement.getAttribute("name")) + " cannot be null\");");
                            sb.append("\n");
                            sb.append("            }");
                            sb.append("\n");
                            sb.append("            this.createOrUpdate"+eElement.getAttribute("name")+"("+GeneratorModel.lop(eElement.getAttribute("name"))+");");
                            sb.append("\n");
                            sb.append("        } catch (Exception var5) {");
                            sb.append("\n");
                            sb.append("            logger.error(var5);");
                            sb.append("\n");
                            sb.append("            apiResponse.setResponseCodeEnum(ResponseCode._999);");
                            sb.append("\n");
                            sb.append("            apiResponse.setResponseMessage(var5.getMessage());");
                            sb.append("\n");
                            sb.append("        }");
                            sb.append("\n");
                            sb.append("        return apiResponse;");
                            sb.append("\n");
                            sb.append("    }");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public ApiResponse doDelete(List<"+ eElement.getAttribute("name") +"> "+ GeneratorModel.lop(eElement.getAttribute("name")) +"List) {");
                            sb.append("\n");
                            sb.append("        ApiResponse apiResponse = new ApiResponse();");
                            sb.append("\n");
                            sb.append("        try {");
                            sb.append("\n");
                            sb.append("            if ("+ GeneratorModel.lop(eElement.getAttribute("name")) +"List.size() < 1) {");
                            sb.append("\n");
                            sb.append("                throw new NullPointerException(\""+ GeneratorModel.lop(eElement.getAttribute("name")) +" cannot be null\");");
                            sb.append("\n");
                            sb.append("            }");
                            sb.append("\n");
                            sb.append("            for ("+eElement.getAttribute("name")+" obj : "+ GeneratorModel.lop(eElement.getAttribute("name")) +"List) {");
                            sb.append("\n");
                            sb.append("                this.delete"+ eElement.getAttribute("name") + "ById(obj.get" + GeneratorModel.cap(eElementCol.getAttribute("name")) + "());");
                            sb.append("\n");
                            sb.append("            }");
                            sb.append("\n");
                            sb.append("        } catch (Exception var5) {");
                            sb.append("\n");
                            sb.append("            logger.error(var5);");
                            sb.append("\n");
                            sb.append("            apiResponse.setResponseCodeEnum(ResponseCode._999);");
                            sb.append("\n");
                            sb.append("            apiResponse.setResponseMessage(var5.getMessage());");
                            sb.append("\n");
                            sb.append("        }");
                            sb.append("\n");
                            sb.append("        return apiResponse;");
                            sb.append("\n");
                            sb.append("    }");
                            sb.append("\n");
                            sb.append("\n");

                            sb.append("    @Override");
                            sb.append("\n");
                            sb.append("    public ApiResponse doPreview("+ eElement.getAttribute("name") +" "+ GeneratorModel.lop(eElement.getAttribute("name")) +") {");
                            sb.append("\n");
                            sb.append("        ApiResponse apiResponse = new ApiResponse();");
                            sb.append("\n");
                            sb.append("        try {");
                            sb.append("\n");
                            sb.append("            apiResponse.setData(this.get"+ eElement.getAttribute("name") +"ById("+GeneratorModel.lop(eElement.getAttribute("name"))+".get"+GeneratorModel.cap(eElementCol.getAttribute("name"))+"()));");
                            sb.append("\n");
                            sb.append("        } catch (Exception var3) {");
                            sb.append("\n");
                            sb.append("            logger.error(var3);");
                            sb.append("\n");
                            sb.append("            apiResponse.setResponseCodeEnum(ResponseCode._999);");
                            sb.append("\n");
                            sb.append("            apiResponse.setResponseMessage(var3.getMessage());");
                            sb.append("\n");
                            sb.append("        }");
                            sb.append("\n");
                            sb.append("        return apiResponse;");
                            sb.append("\n");
                            sb.append("    }");
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

    public static void generateServiceImpl(Document doc) throws IOException {
        String servicePackage = GeneratorRepository.getRootElement(doc) + ".service.impl";
        List<Node> childNodes = GeneratorModel.getChildNodes(doc.getElementsByTagName("service").item(0), "entity");

        for (Node item : childNodes) {
            Element el = (Element) item;
            String data = createServiceImpl(GeneratorRepository.getRootElement(doc), item);
            createJavaFile(data, className(servicePackage, el.getAttribute("name") + "ServiceImpl.java"));
        }
    }
}

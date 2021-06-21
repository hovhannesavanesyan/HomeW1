import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee("Garnik",1);
        System.out.println(generateXml(employee, Employee.class));
    }


    private static String generateXml(Object obj, Class objClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(objClass);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(obj, sw);
        return sw.toString();
    }

}

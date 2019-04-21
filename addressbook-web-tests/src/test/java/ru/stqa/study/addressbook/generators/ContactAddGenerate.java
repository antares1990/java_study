package ru.stqa.study.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactAddGenerate {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter (names = "-f", description = "Target file")
    public String file;

    @Parameter (names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        ContactAddGenerate generator = new ContactAddGenerate();
        JCommander jCommander= new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<ContactAdd> contacts = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCsv(contacts, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(contacts, new File(file));
        } else {
            System.out.println("Unrecognized format" + format);
        }
    }

    private void saveAsJson(List<ContactAdd> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private void saveAsXml(List<ContactAdd> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactAdd.class);
        String xml = xstream.toXML(contacts);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private static void saveAsCsv(List<ContactAdd> contacts, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for (ContactAdd contact : contacts) {
            writer.write(String.format("%s;%s\n", contact.getFirstname(), contact.getLastname()));
        }
        writer.close();
    }

    private static List<ContactAdd> generateContacts(int count) {
        List<ContactAdd> contacts = new ArrayList<ContactAdd>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactAdd().withFirstname(String.format("firstname %s", i))
                    .withLastname(String.format("lastname %s", i)));
        }
        return contacts;
    }
}

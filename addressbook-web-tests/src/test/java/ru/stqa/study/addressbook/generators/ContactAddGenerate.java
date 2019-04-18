package ru.stqa.study.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
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
        save(contacts, new File(file));
    }

    private static void save(List<ContactAdd> contacts, File file) throws IOException {
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

package ru.stqa.study.addressbook.generators;

import ru.stqa.study.addressbook.model.ContactAdd;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactAddGenerate {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<ContactAdd> contacts = generateContacts(count);
        save(contacts, file);

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

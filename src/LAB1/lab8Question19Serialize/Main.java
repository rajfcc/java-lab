package LAB1.lab8Question19Serialize;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void serializeArrayToFile(String filename,ArrayList<Person> list){
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Person> deserializeArrayFromFile(String filename){
        try(FileInputStream fis =new FileInputStream(filename);)
        {
            ArrayList<Person> person_list;
//            FileInputStream fis =new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            person_list = (ArrayList<Person>) ois.readObject();
            ois.close();
//            fis.close();

            return person_list;
        }catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args){
        ArrayList<Person> list_of_person = new ArrayList<>();
        ArrayList<Person> list_of_person_from_file;
        Person person1 = new Person("Ram",23,"KTM");
        Person person2 = new Person("Hari",22,"Lalitpur");

        list_of_person.add(person1);
        list_of_person.add(person2);

        serializeArrayToFile("namelist.txt",list_of_person);

        list_of_person_from_file = deserializeArrayFromFile("namelist.txt");

        if (list_of_person_from_file != null) {
            for (Person i : list_of_person_from_file) {
                System.out.println(i.getName() + " " + i.getAge() + " " + i.getAddress());
            }
        }else{
            System.out.println("Failed to deserialize.");
        }


    }
}

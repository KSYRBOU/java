import java.util.*;
public class TelBook {
    private HashMap<String, TreeSet <String>> tlBook;
    public TelBook() {
        tlBook =  new HashMap<>();
    }
    public void addContact(String name, String phoneNumber) {
        TreeSet<String> phones = tlBook.getOrDefault(name, new TreeSet<>()); 
        phones.add(phoneNumber); 
        tlBook.put(name, phones);
    }
    
    public void removeContact(String name, String phoneNumber) { 
        TreeSet<String> phones = tlBook.getOrDefault(name, new TreeSet<>()); 
        phones.remove(phoneNumber); 
        if (phones.isEmpty()) { 
            tlBook.remove(name);
        } else { 
            tlBook.put(name, phones);
        }
    }

    public TreeSet<String> getPhones(String name) { 
        return tlBook.get(name); 
    }

    public HashMap<String, TreeSet<String>> getAllContacts() {
        return tlBook;
    }

    public void printBook() {
        for (String name : tlBook.keySet()) { 
            TreeSet<String> phones = tlBook.get(name); 
            System.out.println(name + ": " + phones);
        }
    }

    public List<String> sortContactsByPhones() {
        List<Map.Entry<String, TreeSet<String>>> sortedEntries = new ArrayList<>(tlBook.entrySet()); 
            sortedEntries.sort((e1, e2) -> e2.getValue().size() - e1.getValue().size()); 
            List<String> result = new ArrayList<>(); 
            for (Map.Entry<String, TreeSet<String>> entry : sortedEntries) {
               result.add(entry.getKey() + ": " + entry.getValue()); 
            }
               return result; 
    }
}

class NewTelBook {
    public static void main(String[] args) {
        TelBook tlBook = new TelBook();
        tlBook.addContact("Man 1", "123234356");
        tlBook.addContact("Man 1", "679808000");
        tlBook.addContact("Woman 1", "456788986");
        tlBook.addContact("Woman 2", "213247899");
    
        tlBook.printBook(); 
        TreeSet<String> manPhones = tlBook.getPhones("Man 1"); 
    
        System.out.println("Man 1 phones: " + manPhones); 
    
        tlBook.removeContact("Man 1", "123234356"); 
        TreeSet<String> manRemove = tlBook.getPhones("<Man 1>"); 
        System.out.println("Man 1 remove: " + manRemove); 
    
        List<String> sortedContacts = tlBook.sortContactsByPhones(); 
        System.out.println("Sorted contacts by phones:"); 
        for (String contact : sortedContacts) { 
            System.out.println(contact); }
    }
}
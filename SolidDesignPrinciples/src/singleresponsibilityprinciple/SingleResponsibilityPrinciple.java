package singleresponsibilityprinciple;
import java.util.ArrayList;
import java.util.List;
import java.io.*;




class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters and setters for title and author

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

class Books {
    private List<Book> bookList;

    public Books() {
        bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public List<Book> getAllBooks() {
        return bookList;
    }
}



class Save {
    public void saveToFile(List<Book> books, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Book book : books) {
                writer.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Print {
    public void printBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}



public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        // Create some books
        Book book1 = new Book("Book 1", "Author 1");
        Book book2 = new Book("Book 2", "Author 2");

        // Create a Books instance
        Books books = new Books();

        // Add books to the collection
        books.addBook(book1);
        books.addBook(book2);

        // Print the books
        Print printer = new Print();
        List<Book> allBooks = books.getAllBooks();
        printer.printBooks(allBooks);

        // Save the books to a file
        Save saver = new Save();
        saver.saveToFile(allBooks, "books.txt");
    }
}





package com.example;

import java.io.*;
import java.util.*;

public class NotesStore {
    private List<String[]> notes = new ArrayList<>();
    private String filePath = "data/notes.csv";

    public NotesStore() {
        loadFromFile();
    }

    private void loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            notes.clear();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2);
                if (parts.length == 2) {
                    notes.add(parts);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading notes file: " + e.getMessage());
        }
    }

    private void saveToFile() {
        File file = new File(filePath);
        file.getParentFile().mkdirs(); // Создаем папку data, если ее нет
        try (PrintWriter writer = new PrintWriter(file)) {
            for (String[] note : notes) {
                writer.println(note[0] + ";" + note[1]);
            }
        } catch (IOException e) {
            System.err.println("Error writing notes file: " + e.getMessage());
        }
    }

    public void addNote(String text) {
        int newId = notes.size() + 1;
        notes.add(new String[]{String.valueOf(newId), text});
        saveToFile();
    }

    public List<String[]> getAllNotes() {
        return new ArrayList<>(notes);
    }
}
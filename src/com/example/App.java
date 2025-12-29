package com.example;

public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: --cmd=<command> [--text=<text>|--id=<id>]");
            return;
        }

        String command = null;
        String text = null;
        String id = null;

        for (String arg : args) {
            if (arg.startsWith("--cmd=")) {
                command = arg.substring(6);
            } else if (arg.startsWith("--text=")) {
                text = arg.substring(7);
            } else if (arg.startsWith("--id=")) {
                id = arg.substring(5);
            }
        }

        NotesStore store = new NotesStore();

        switch (command) {
            case "add":
                if (text == null || text.isEmpty()) {
                    System.out.println("Error: text is required for add command");
                    return;
                }
                store.addNote(text);
                System.out.println("Note added");
                break;

            case "list":
                var allNotes = store.getAllNotes();
                if (allNotes.isEmpty()) {
                    System.out.println("(empty)");
                } else {
                    for (String[] note : allNotes) {
                        System.out.println(note[0] + ";" + note[1]);
                    }
                }
                break;

            case "count":
                int count = store.getNotesCount();
                System.out.println(count);
                break;

            default:
                System.out.println("Unknown command: " + command);
                break;
        }
    }
}
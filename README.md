# Notes CLI

Консольное приложение для управления заметками.

## Команды

- `--cmd=add --text="Текст заметки"` - добавить заметку
- `--cmd=list` - показать все заметки

## Запуск

### Локально
```bash
javac -d out src/com/example/*.java
java -cp out com.example.App --cmd=list
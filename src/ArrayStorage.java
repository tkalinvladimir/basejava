import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[3];
    int size;

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            }
        }
        size = 0;
    }

    void save(Resume resume) {
        storage[size] = resume;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        boolean beenDeleted = false;
        for (int i = 0; i < size; i++) {
            if (!beenDeleted && storage[i].uuid.equals(uuid)) {
                beenDeleted = true;
                size--;
            }
            if (beenDeleted) {
                if (i == size) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[i+1];
                    storage[i+1] = null;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        return size;
    }
}

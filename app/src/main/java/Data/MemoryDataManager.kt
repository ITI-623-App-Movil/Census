package Data

import Entity.Person

object MemoryDataManager : IDataManager {
    private var personList = mutableListOf<Person>()

    override fun add(person: Person) {
        personList.add(person)
    }

    override fun update(person: Person) {
        remove(person.ID)
        add(person)
    }

    override fun remove(id: String) {
        personList.removeIf { it.ID.trim() == id.trim() }
    }

    override fun getAll() = personList

    override fun getById(id: String): Person? {
        try {
            val result = personList.filter { it.ID.trim() == id.trim() }
            return if (result.any()) result[0] else null
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getByFullName(fullName: String): Person? {
        try {
            val result = personList.filter { it.FullName().trim() == fullName.trim() }
            return if (result.any()) result[0] else null
        } catch (e: Exception) {
            throw e
        }
    }
}
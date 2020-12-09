package eight

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.io.File

data class User(
    val id: Int,
    val name: String,
    @SerializedName("fname")
    val surname: String,
    var country: String,
    val age: Int,
    @SerializedName("is_teen")
    val isTeen: Boolean

)

enum class AgeFilter {
    AGE, OVER_AGE, YOUNGER_AGE
}

class UserDbWrapper {
    var file = File("src/main/kotlin/eight/users_ds.json")
    var users = getListObjectsFromJsonString<User>(file.readText(Charsets.UTF_8))


    fun getUsersFilteredByCountry(country: String): List<User> {
        return users.filter { it.country == country }
    }

    fun getUsersByAgeFilter(filter: AgeFilter, age: Int): List<User> {
        return when (filter) {
            AgeFilter.AGE -> users.filter { it.age == age }
            AgeFilter.OVER_AGE -> users.filter { it.age > age }
            AgeFilter.YOUNGER_AGE -> users.filter { it.age <= age }
        }
    }

    fun getTeenOrNotTeenUsers(isTeen: Boolean): List<User> {
        return users.filter { it.isTeen == isTeen }
    }

    fun getUsersWithWrongTeenValue(): MutableList<User> {
        val usersWithWrongEntry = mutableListOf<User>()
        users.forEach {
            when (it.country) {
                "Russia" -> {
                    if (it.isTeen != it.age >= 18) usersWithWrongEntry.add(it)
                }
                "USA" -> {
                    if (it.isTeen != it.age >= 21) usersWithWrongEntry.add(it)
                }
                "Japan", "Thailand" -> {
                    if (it.isTeen != it.age >= 20) usersWithWrongEntry.add(it)
                }
            }
        }
        return usersWithWrongEntry
    }
}

inline fun <reified T> getListObjectsFromJsonString(jsonString: String): List<T> {
    val type = TypeToken.getParameterized(ArrayList::class.java, T::class.java).type
    return Gson().fromJson(jsonString, type)
}
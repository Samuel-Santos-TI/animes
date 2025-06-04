
import classes.Anime
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

fun main() {

    println("Qual o nome do anime que você deseja procurar o nome de todas as franquias: ")
    val escolha = readln()

    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.jikan.moe/v4/anime?q=$escolha"))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val dados = response.body()

    val gson = Gson()

    val anime = gson.fromJson(dados, Anime::class.java)

//    fun VerTipo (valor: Any): String {
//        return valor::class.simpleName ?: "Desconhecido"
//    }


    for (f in anime.data){
        println(f.title)
        println("\n ${f.synopsis} \n")
    }


}
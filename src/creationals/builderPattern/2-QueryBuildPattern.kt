package creationals.builderPattern
// Query Builder
/**
 * Debe de tener los siguientes métodos:
 * - constructor(table: string)
 * - select(fields: string[]): QueryBuilder -- si no se pasa ningún campo, se seleccionan todos con el (*)
 * - where(condition: string): QueryBuilder - opcional
 * - orderBy(field: string, order: string): QueryBuilder - opcional
 * - limit(limit: number): QueryBuilder - opcional
 * - execute(): string - retorna la consulta SQL
 *
 ** Ejemplo de uso:
const usersQuery = new QueryBuilder("users") // users es el nombre de la tabla
.select("id", "name", "email")
.where("age > 18")
.where("country = 'Cri'")
.orderBy("name", "ASC")
.limit(10)
.execute();

console.log('Consulta: ', usersQuery);
// Select id, name, email from users where age > 18 and country = 'Cri' order by name ASC limit 10;
// Select id,name,email from users where age > 18 and country = 'Cri' order by name ASC limit 10
 */

fun main(){
    var usersQuery =  QueryBuilder("users").apply {
        this.select("id")
        this.select("name")
        this.select("email")
        this.where("age > 18")
        this.where("country = 'Cri'")
        this.orderBy("name", "ASC")
        this.limit(10)
    }.build()
    usersQuery.execute()
}
class Query (table:String){
    var table = table
    var select = "*"
    var where = ""//opcional
    var orderByName = ""//opcional
    var orderByDesc = ""//opcional
    var limit = 0//opcional
    fun execute(){
        System.out.println("Select $select from $table" +
                " ${if (where.isNotEmpty()) "where $where" else ""}" +
                " ${if (orderByName.isNotEmpty()) "order by $orderByName $orderByDesc" else ""}" +
                " ${"limit $limit"};")
    }
}
class QueryBuilder(table: String) {
    val query = Query(table)

    fun select(select: String): QueryBuilder {
        this.query.select = if (select != "*") if (this.query.select=="*") select else "${this.query.select},$select" else select
        return this
    }

    fun where(where: String): QueryBuilder {
        this.query.where = if (this.query.where.isNotEmpty())this.query.where + " and "+ where else where
        return this
    }

    fun orderBy(orderByName: String,orderByDesc: String): QueryBuilder {
        this.query.orderByName = orderByName
        this.query.orderByDesc = orderByDesc
        return this
    }

    fun limit(limit: Int): QueryBuilder {
        this.query.limit = limit
        return this
    }

    fun build():Query{
        return query
    }
}
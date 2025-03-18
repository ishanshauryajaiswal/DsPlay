package graph

import java.util.concurrent.ConcurrentHashMap

class xpAirportConnections {

    fun airportConnections(airports: List<String>, routes: List<Pair<String, String>>, startingAirport: String): Int {
        val routesMap = HashMap<String, ArrayList<String>>()
        val indirectRouteMap = ConcurrentHashMap<String, HashSet<String>>()
        airports.forEach {
            routesMap.put(it, ArrayList())
            indirectRouteMap.put(it, HashSet())
        }
        routes.forEach {
            routesMap.getOrPut(it.first) { ArrayList() }.add(it.second)
        }
        val visited = HashSet<String>()
        airports.forEach {
            dfs(it, routesMap, indirectRouteMap, visited)
        }
        indirectRouteMap.forEach{
            it.value.remove(it.key)
            it.value.forEach { ap ->
                indirectRouteMap.remove(ap)
            }
        }
        var count = 0
        indirectRouteMap.forEach{
            if(it.key != startingAirport && !routesMap[startingAirport]!!.contains(it.key))
                count++
        }
        return count
    }

    private fun dfs(
        airport: String,
        routesMap: java.util.HashMap<String, java.util.ArrayList<String>>,
        indirectRouteMap: ConcurrentHashMap<String, HashSet<String>>,
        visited: java.util.HashSet<String>
    ): HashSet<String> {
        if(visited.contains(airport)){
            return indirectRouteMap[airport]!!
        }
        visited.add(airport)
        routesMap[airport]!!.forEach {
            indirectRouteMap[airport]!!.add(it)
            indirectRouteMap[airport]!!.addAll(dfs(it, routesMap, indirectRouteMap, visited))
        }
        return indirectRouteMap[airport]!!
    }


}
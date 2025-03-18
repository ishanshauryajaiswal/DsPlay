package graph

class xpertDfs {
}

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun depthFirstSearch(): List<String> {
        val list = ArrayList<String>()
        val visited = HashSet<String>()
        dfsUtil(visited, this, list)
        return list
    }

    fun dfsUtil(visited: HashSet<String>, node : Node, list: ArrayList<String>){
        if(visited.contains(node.name)){
            return
        }
        visited.add(node.name)
        list.add(node.name)
        node.children.forEach{
            dfsUtil(visited, it, list)
        }
    }
}
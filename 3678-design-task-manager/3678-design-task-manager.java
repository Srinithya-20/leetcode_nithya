class TaskManager {

    class Task {
        int userId, id, priority;
        Task(int u, int i, int p) {
            userId = u;
            id = i;
            priority = p;
        }
    }

    Map<Integer, Task> tasksMap; 
    TreeSet<Task> tasksSet; 

    public TaskManager(List<List<Integer>> tasks) {
        
        tasksMap = new HashMap<>();
        tasksSet = new TreeSet<>((a, b) -> {
            if (a.priority == b.priority) return b.id - a.id;
            return b.priority - a.priority;
        });
        for (List<Integer> t : tasks) {
            int user = t.get(0);
            int id = t.get(1);
            int pr = t.get(2);
            Task task = new Task(user, id, pr);
            tasksMap.put(id, task);
            tasksSet.add(task);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        
        Task task = new Task(userId, taskId, priority);
        tasksMap.put(taskId, task);
        tasksSet.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
       
        Task old = tasksMap.get(taskId);
        tasksSet.remove(old);
        Task updated = new Task(old.userId, old.id, newPriority);
        tasksMap.put(taskId, updated);
        tasksSet.add(updated);
    }
    
    public void rmv(int taskId) {
       
        Task curr = tasksMap.get(taskId);
        tasksMap.remove(taskId);
        tasksSet.remove(curr);
    }
    
    public int execTop() {
       
        if (tasksSet.isEmpty()) return -1;
        Task top = tasksSet.pollFirst();
        
        tasksMap.remove(top.id);
        return top.userId;
    }
}
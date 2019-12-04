public class MeteoStation extends Observable {

    @Override
    public Observer[] getSubscribers() {
        Observer[] subArr = new Observer[subscribers.size()];
        for(int i = 0; i<subscribers.size(); i++){
            subArr[i] = subscribers.get(i);
        }
        return subArr;
    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {
        for(Observer o : super.subscribers){
            if(pair.getZone() == o.getZone()){
                o.update(pair.getAlert());
            }
        }
    }

    @Override
    public void addObserver(Observer sub) {
        if(!subscribers.contains(sub)) {
            subscribers.add(sub);
        }
    }

    @Override
    public boolean removeObserver(Observer sub) {
        for(Observer o : subscribers){
            if(o.equals(sub)){
                subscribers.remove(o);
                return true;
            }
        }
        return false;
    }

    @Override
    public void setAlert(String alert, int zone) {
        Pair newPair = new Pair(alert, zone);
        broadcast(newPair);
    }
}

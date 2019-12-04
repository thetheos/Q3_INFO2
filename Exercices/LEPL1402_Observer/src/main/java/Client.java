public class Client extends Observer {

        public Client(int zone){
            super.zone = zone;
            news = "";
        }


        @Override
        public void update(Object o) {
            news = (String) o;
        }

        @Override
        public int getZone() {
            return zone;
        }

        @Override
        public String getNews() {
            return news;
        }
}
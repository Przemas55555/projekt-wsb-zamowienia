class Order {
    private int id, status;
    private String destinationCity, destinationPostCode, destinationStreet;
    
    public Order(int id, String destinationCity, String destinationPostCode,
                 String destinationStreet, int status) {
        this.id = id;
        this.destinationCity = destinationCity;
        this.destinationPostCode = destinationPostCode;
        this.destinationStreet = destinationStreet;
        this.status = status   ;
    }
    
    public int getId()
    {
        return this.id;
    }
    public String getDestinationCity()
    {
        return this.destinationCity;
    }
    public String getDestinationPostCode()
    {
        return this.destinationPostCode;
    }
    public String getDestinationStreet()
    {
        return this.destinationStreet;
    }
    public int getStatus()
    {
        return this.status;
    }
}

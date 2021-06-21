package example;

interface power380{
    public void print();
}

interface power220{
    public void print220();
}

class V380 implements power380{

    @Override
    public void print(){
        System.out.println("зарядка 380");
    }

}

class V220 implements power220{

    @Override
    public void print220(){
        System.out.println("зарядка 220");
    }
}

class Adapter implements power380{
    power220 pw220;

    public Adapter(power220 pw220){
        this.pw220 = pw220;
    }

    @Override
    public void print(){
        pw220.print220();
    }
}

class CentralProcessor{
    private power380 V;
    public CentralProcessor(power380 V){
        this.V = V;
    }

    public void work(){
        V.print();
    }
}

class Scratch{
    public static void main(String[] args){

        power380 pw380 = new V380();
        CentralProcessor cp = new CentralProcessor(pw380);
        cp.work();

        Adapter pw220 = new Adapter(new V220());
        CentralProcessor cpRus = new CentralProcessor(pw220);
        cpRus.work();
    }}
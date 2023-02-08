import java.util.ArrayList;

public abstract class Character {
    private String name;
    private int hp;
    private int mp;
    private int attack;
    private boolean dead;

    public String getName(){
        return name;
    }
    public int getHp(){
        return hp;
    }
    public int getMp(){
        return mp;
    }
    public int getAttack(){
        return attack;
    }

    public boolean isDead(){
        return this.dead;
    }

    private ArrayList<Action> actions = new ArrayList<>();

    public ArrayList<Action> getActions(){
        return actions;
    }

    Character(String name, int hp, int mp, int attack) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
    }

    void addAction(Action action) {
        actions.add(action);
    }

    void showStatus() {
        System.out.printf("%s:HP %d  MP %d\n", name, hp, mp);
    }

    abstract void act(ArrayList<Character> targets); //サブクラスで定義する
    public int setConsumption() {
        return 0;
    }

    void damaged(int damage) {
        if(damage < 0) {
           throw new IllegalArgumentException("Character.damaged:引数damegeは正の数である必要があります");
        }
        hp -= damage;
        mp -= setConsumption();
    }

    public void recover(int value){
    }
    public void consumeMp(int consumption){

    }

    public void wondered(int damage){
        hp -= damage;
        if(hp < 0){
            this.dead= true;
            System.out.printf("5sは倒れた。\n", name);
        }
        
    }

     
}

package model;

public class resources{
    private String content;
    private int amount;

    public resources(String content, int amount) {
        this.content = content;
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "resouces{" + "content=" + content + ", amount=" + amount + '}';
    }
    
}
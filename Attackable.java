public interface Attackable {
  // Attackable Things must have health
  int getHealth();

  void setHealth(int health);

  void takeDamage(int damageAmount);
}
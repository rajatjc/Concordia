public class TestInherit {

    public static void main(String[] arg) {
      Parent P   = new Parent();
      Child C    = new Child();
      Stranger S = new Stranger();

      System.out.println("\nMain internal access:\n");

      System.out.println("class TestInherit can access P.pv_public: " + P.pv_public);
      System.out.println("class TestInherit can access P.pv_protected: " + P.pv_protected);
//      System.out.println("class TestInherit can access(d) P.pv_private: " + P.pv_private);
      System.out.println("class TestInherit can ask P to modify P.pv_private!");
      P.modify_pv_private();
      System.out.println("class TestInherit can ask P for value of pv_private: " + P.pvPrivate());
      
      System.out.println("\nMain access via Parent methods:\n");

      P.pmPublic();
      P.pmProtected();
//      P.pmPrivate();

      System.out.println("\nMain access via Parent method Access:\n");
      P.Access();
      System.out.println("\nMain access via Child method ParentAccess:\n");
      C.ParentAccess();
      System.out.println("\nMain access via Stranger method ParentAccess:\n");
      S.ParentAccess();

    }  // Of method main

}  // Of class TestInherit

class Parent {

    public int pv_public = 1;
    protected int pv_protected = 2;
    private int pv_private = 3;

    public void pmPublic() {
      System.out.println("class parent can access pmPublic!");
    }  // Of method pmPublic

    protected void pmProtected() {
      System.out.println("class parent can access pmProtected!");
    }  // Of method pmProtected

    private void pmPrivate() {
      System.out.println("class parent can access pmPrivate!");
    }  // Of method pmPrivate

    public void modify_pv_private() {
      pv_private = pv_private + 1;
    }  // Of method modify_pv_private

    public int pvPrivate() {
      return(pv_private);
    }  // Of method pvPrivate

    public void Access() {

      System.out.println("class Parent can access pv_public: " + pv_public);
      System.out.println("class Parent can access pv_protected: " + pv_protected);
      System.out.println("class Parent can access pv_private: " + pv_private);
      System.out.println("class Parent can modify pv_private!");
      modify_pv_private();
      System.out.println("class Parent can access pv_private: " + pvPrivate());
      
      pmPublic();
      pmProtected();
      pmPrivate();

    }  // Of method Access

}  // Of class Parent

class Child extends Parent {

    public void ParentAccess() {

      System.out.println("class Child can access pv_public: " + pv_public);
      System.out.println("class Child can access pv_protected: " + pv_protected);
//      System.out.println("  I can access(d) pv_private: " + pv_private);
      System.out.println("class Child can ask Parent to modify pv_private!");
      modify_pv_private();
      System.out.println("class Child can ask Parent for value of pv_private: " + pvPrivate());
      
      pmPublic();
      pmProtected();
//      pmPrivate();

    }  // Of method ParentAccess

}  // Of class Child

class Stranger {
    
    Parent P = new Parent();

    public void ParentAccess() {

      System.out.println("Stranger can access pv_public: " + P.pv_public);
      System.out.println("Stranger can access pv_protected: " + P.pv_protected);
//      System.out.println("Stranger can access(d) pv_private: " + P.pv_private);
      System.out.println("Stranger can ask P to modify pv_private!");
      P.modify_pv_private();
      System.out.println("Stranger can ask P for value of pv_private: " + P.pvPrivate());
      
      P.pmPublic();
      P.pmProtected();
//      P.pmPrivate();

    }  // Of method ParentAccess


}  // Of class Stranger

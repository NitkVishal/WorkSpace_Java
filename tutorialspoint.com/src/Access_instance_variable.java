public class Access_instance_variable{
   
   int puppyAge;

   public Access_instance_variable(String name){
      // This constructor has one parameter, name.
      System.out.println("Passed Name is :" + name ); 
   }
   public void setAge( int age ){
       puppyAge = age;
   }

   public int getAge( ){
       System.out.println("Puppy's age is :" + puppyAge ); 
       return puppyAge;
   }
   public static void main(String []args){
      /* Object creation */
      Access_instance_variable myPuppy = new Access_instance_variable( "tommy" );

      /* Call class method to set puppy's age */
      myPuppy.setAge( 2 );

      /* Call another class method to get puppy's age */
      myPuppy.getAge( );

      /* You can access instance variable as follows as well */
      System.out.println("Variable Value :" + myPuppy.puppyAge ); 
   }
}
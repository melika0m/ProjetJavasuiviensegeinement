package main;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Authentification.LoginForm;
import dao.AvancementCoursDAO;
import dao.CourseDAO;
import dao.DepartmentDAO;
import dao.MatiereDAO;
import dao.ProfesseurDAO;
import dao.SemestreDAO;
import daoimp.CourseDAOImpl;
import daoimp.DepartmentDAOImpl;
import daoimp.ProfesseurDAOImpl;
import daoimp.MatiereDAOImpl;
import daoimp.SemestreDAOImpl;
import models.AvancementCours;
import models.Course;
import models.Department;
import models.Matiere;
import models.Professeur;
import models.Semestre;
//import Authentification.InsertUser;
public class Show {

	

	
	    public static void main(String[] args) {
	        try {
	            Connection con = dbcnx.getConnection();
	           
	            // Assurez-vous que cette m�thode statique fonctionne correctement
	         // Inside Show.java
	            

	            SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    new LoginForm().setVisible(true);
	                }
	            });
	            String username = "Eeee";
	            String password = "1234";
	            insertUser(username, password);
	           
//	            DepartmentDAO departmentDAO = new DepartmentDAOImpl(con);
//	            Scanner scanner = new Scanner(System.in);
//
//	            while (true) {
//	                System.out.println("\nMenu:");
//	                System.out.println("1. Ajouter un d�partement");
//	                System.out.println("2. Afficher un d�partement");
//	                System.out.println("3. Afficher tous les d�partements");
//	                System.out.println("4. Mettre � jour un d�partement");
//	                System.out.println("5. Supprimer un d�partement");
//	                System.out.println("6. Quitter");
//	                System.out.print("Entrez votre choix: ");
//
//	                int choice = scanner.nextInt();
//	                scanner.nextLine(); // Consommer la nouvelle ligne
//
//	                switch (choice) {
//	                    case 1:
//	                        System.out.println("Entrez l'ID du d�partement: ");
//	                        int id = scanner.nextInt();
//	                        scanner.nextLine(); // Consommer la nouvelle ligne
//	                        System.out.println("Entrez le nom du d�partement: ");
//	                        String name = scanner.nextLine();
//	                        departmentDAO.addDepartment(new Department(id, name));
//	                        System.out.println("D�partement ajout� avec succ�s.");
//	                        break;
//	                    case 2:
//	                        System.out.println("Entrez l'ID du d�partement � afficher: ");
//	                        id = scanner.nextInt();
//	                        Department department = departmentDAO.getDepartment(id);
//	                        System.out.println(department != null ? department : "D�partement non trouv�.");
//	                        break;
//	                    case 3:
//	                        List<Department> departments = departmentDAO.getAllDepartments();
//	                        for (Department dep : departments) {
//	                            System.out.println(dep);
//	                        }
//	                        break;
//	                    case 4:
//	                        System.out.println("Entrez l'ID du d�partement � mettre � jour: ");
//	                        id = scanner.nextInt();
//	                        scanner.nextLine(); // Consommer la nouvelle ligne
//	                        System.out.println("Entrez le nouveau nom du d�partement: ");
//	                        name = scanner.nextLine();
//	                        departmentDAO.updateDepartment(new Department(id, name));
//	                        System.out.println("D�partement mis � jour avec succ�s.");
//	                        break;
//	                    case 5:
//	                        System.out.println("Entrez l'ID du d�partement � supprimer: ");
//	                        id = scanner.nextInt();
//	                        departmentDAO.deleteDepartment(id);
//	                        System.out.println("D�partement supprim� avec succ�s.");
//	                        break;
//	                    case 6:
//	                        System.out.println("Au revoir !");
//	                        return;
//	                    default:
//	                        System.out.println("Choix non valide. Veuillez r�essayer.");
//	                }
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
	        ProfesseurDAO professeurDAO = new ProfesseurDAOImpl(con);
            Scanner scanner1 = new Scanner(System.in);
	           
	       
            SemestreDAO semestreDAO = new SemestreDAOImpl(con);
            Scanner scanner = new Scanner(System.in);
            
            MatiereDAO matiereDAO = new MatiereDAOImpl(con);
            Scanner scanner2 = new Scanner(System.in);
            
            CourseDAO courseDAO = new CourseDAOImpl(con);
            Scanner scanner3 = new Scanner(System.in);
            
            AvancementCoursDAO avancementCoursDAO = new CourseDAOImpl(con);
            Scanner scanner4 = new Scanner(System.in);
	        

            while (true) {
                System.out.println("\nMenu Principal:");
                System.out.println("1. G�rer les professeurs");
                System.out.println("2. G�rer les semestres");
                System.out.println("3. G�rer les mati�res");
                System.out.println("4. G�rer les cours");
                System.out.println("5. G�rer les avancements");
                System.out.println("6. Quitter");
                System.out.print("Entrez votre choix: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // G�rer les professeurs
                        manageProfesseurs(scanner1, professeurDAO);
                    	
                        break;
                    case 2:
                        // G�rer les semestres
                        manageSemestres(scanner, semestreDAO);
                        break;
                    case 3:
                    	//gggggg
                        manageMatieres(scanner2, matiereDAO);
                        break;
                    case 4:
                    	//gggggg
                    	manageCourses(scanner3, courseDAO);
                        break;
                    case 5:
                    	//gggggg
                    	manageAvancementCours(scanner4, avancementCoursDAO);
                        break;
                    case 6:
                        // Quitter
                        System.out.println("Fin du programme.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix non valide. Veuillez r�essayer.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	    private static void insertUser(String username, String password) {
			// TODO Auto-generated method stub
			
		}
		protected static void createAndShowGUI() {
			// TODO Auto-generated method stub
			
		}
		private static void manageAvancementCours(Scanner scanner4, AvancementCoursDAO avancementCoursDAO) throws Exception {
	        while (true) {
	            System.out.println("\nGestion des Avancements des Cours:");
//	            System.out.println("1. Ajouter un avancement");
	            System.out.println("2. Voir un avancement par ID");
	            System.out.println("3. Lister tous les avancements");
	            System.out.println("4. Mettre � jour un avancement");
	            System.out.println("5. Supprimer un avancement");
	            System.out.println("6. Retour");
	            System.out.print("Choisissez une option: ");
	            int choice = scanner4.nextInt();
	            scanner4.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
//	                    addAvancementCours(scanner4, avancementCoursDAO);
//	                    break;
	                case 2:
	                    viewAvancementCours(scanner4, avancementCoursDAO);
	                    break;
	                case 3:
	                    listAllAvancements(avancementCoursDAO);
	                    break;
	                case 4:
	                    updateAvancementCours(scanner4, avancementCoursDAO);
	                    break;
	                case 5:
	                    deleteAvancementCours(scanner4, avancementCoursDAO);
	                    break;
	                case 6:
	                    return; // Return to the main menu
	                default:
	                    System.out.println("Choix non valide. Veuillez r�essayer.");
	            }
	        }
	    }
	    private static void viewAvancementCours(Scanner scanner4, AvancementCoursDAO avancementCoursDAO) throws Exception {
	        System.out.print("Entrez l'ID de l'avancement � voir: ");
	        int avancementID = scanner4.nextInt();
	        AvancementCours avancement = avancementCoursDAO.getAvancement(avancementID);
	        if (avancement != null) {
	            System.out.println("CoursID: " + avancement.getCoursID() + ", HeuresDonn�es: " + avancement.getHeuresDonnees() + ", Date: " + avancement.getDate());
	        } else {
	            System.out.println("Aucun avancement trouv� avec l'ID " + avancementID);
	        }
	    }
	    private static void listAllAvancements(AvancementCoursDAO avancementCoursDAO) throws Exception {
	        List<AvancementCours> avancements = avancementCoursDAO.getAllAvancements();
	        if (avancements.isEmpty()) {
	            System.out.println("Aucun avancement trouv�.");
	        } else {
	            for (AvancementCours avancement : avancements) {
	                System.out.println("AvancementID: " + avancement.getAvancementID() + ", CoursID: " + avancement.getCoursID() + ", HeuresDonn�es: " + avancement.getHeuresDonnees() + ", Date: " + avancement.getDate());
	            }
	        }
	    }
	    private static void updateAvancementCours(Scanner scanner4, AvancementCoursDAO avancementCoursDAO) throws Exception {
	        System.out.print("Entrez l'ID de l'avancement � mettre � jour: ");
	        int avancementID = scanner4.nextInt();
	        
	        System.out.print("Nouveau CoursID: ");
	        int coursID = scanner4.nextInt();
	        
	        System.out.print("Nouvelles HeuresDonn�es: ");
	        int heuresDonnees = scanner4.nextInt();
	        
	        System.out.print("Nouvelle Date (YYYY-MM-DD): ");
	        String dateString = scanner4.next();
	        Date date = Date.valueOf(dateString); // Convert string to SQL Date
	        
	        AvancementCours avancement = new AvancementCours(avancementID, coursID, heuresDonnees, date);
	        avancementCoursDAO.updateAvancement(avancement);
	        System.out.println("Avancement mis � jour avec succ�s.");
	    }

	    private static void deleteAvancementCours(Scanner scanner4, AvancementCoursDAO avancementCoursDAO) throws Exception {
	        System.out.print("Entrez l'ID de l'avancement � supprimer: ");
	        int avancementID = scanner4.nextInt();
	        avancementCoursDAO.deleteAvancement(avancementID);
	        System.out.println("Avancement supprim� avec succ�s.");
	    }

	 // ##########

	    private static void manageCourses(Scanner scanner3, CourseDAO courseDAO) throws Exception {
	        while (true) {
	            System.out.println("\nGestion des Cours:");
	            System.out.println("1. Ajouter un cours");
	            System.out.println("2. Voir un cours par ID");
	            System.out.println("3. Voir tous les cours");
	            System.out.println("4. Mettre � jour un cours");
	            System.out.println("5. Supprimer un cours");
	            System.out.println("6. Retour");
	            System.out.print("Choisissez une option: ");
	            int choice = scanner3.nextInt();
	            scanner3.nextLine(); // Consume newline

	            switch (choice) {
	                case 1:
	                    addCourse(scanner3, courseDAO);
	                    break;
	                case 2:
	                    viewCourse(scanner3, courseDAO);
	                    break;
	                case 3:
	                    viewAllCourses(courseDAO);
	                    break;
	                case 4:
	                    updateCourse(scanner3, courseDAO);
	                    break;
	                case 5:
	                    deleteCourse(scanner3, courseDAO);
	                    break;
	                case 6:
	                    return; // Return to the main menu
	                default:
	                    System.out.println("Choix non valide. Veuillez r�essayer.");
	            }
	        }
	    }
	    private static void addCourse(Scanner scanner3, CourseDAO courseDAO) throws Exception {
	        System.out.print("Entrez l'ID du cours: ");
	        int coursID = scanner3.nextInt();
	        scanner3.nextLine(); // Consume newline
	        
	        System.out.print("Nom du cours: ");
	        String nomCours = scanner3.nextLine();

	        System.out.print("Code du cours: ");
	        String codeCours = scanner3.nextLine();

	        System.out.print("ID du professeur: ");
	        int professeurID = scanner3.nextInt();

	        System.out.print("Heures par semaine: ");
	        int heuresParSemaine = scanner3.nextInt();
	        scanner3.nextLine(); // Consume newline

	        System.out.print("Semestre: ");
	        String semestre = scanner3.nextLine();

	        System.out.print("Volume horaire total: ");
	        int volumeHoraireTotal = scanner3.nextInt();
	        scanner3.nextLine(); // Consume newline
	        
	        Course course = new Course(coursID, nomCours, codeCours, professeurID, heuresParSemaine, semestre, volumeHoraireTotal);
	        courseDAO.addCourse(course);
	        System.out.println("Cours ajout� avec succ�s.");
	    }
	    private static void viewCourse(Scanner scanner3, CourseDAO courseDAO) throws Exception {
	        System.out.print("Entrez l'ID du cours � voir: ");
	        int coursID = scanner3.nextInt();
	        scanner3.nextLine(); // Consume newline
	        
	        Course course = courseDAO.getCourse(coursID);
	        if (course != null) {
	            System.out.println("Cours ID: " + course.getCoursID() + ", Nom: " + course.getNomCours() + ", Code: " + course.getCodeCours() + ", Professeur ID: " + course.getProfesseurID() + ", Heures par semaine: " + course.getHeuresParSemaine() + ", Semestre: " + course.getSemestre() + ", Volume horaire total: " + course.getVolumeHoraireTotal());
	        } else {
	            System.out.println("Aucun cours trouv� avec l'ID " + coursID);
	        }
	    }
	    private static void viewAllCourses(CourseDAO courseDAO) throws Exception {
	        List<Course> courses = courseDAO.getAllCourses();
	        if (courses.isEmpty()) {
	            System.out.println("Aucun cours disponible.");
	        } else {
	            for (Course course : courses) {
	                System.out.println("Cours ID: " + course.getCoursID() + ", Nom: " + course.getNomCours() + ", Code: " + course.getCodeCours() + ", Professeur ID: " + course.getProfesseurID() + ", Heures par semaine: " + course.getHeuresParSemaine() + ", Semestre: " + course.getSemestre() + ", Volume horaire total: " + course.getVolumeHoraireTotal());
	            }
	        }
	    }
	    private static void updateCourse(Scanner scanner3, CourseDAO courseDAO) throws Exception {
	        System.out.print("Entrez l'ID du cours � mettre � jour: ");
	        int coursID = scanner3.nextInt();
	        scanner3.nextLine(); // Consume newline

	        System.out.print("Nouveau nom du cours: ");
	        String nomCours = scanner3.nextLine();

	        System.out.print("Nouveau code du cours: ");
	        String codeCours = scanner3.nextLine();

	        System.out.print("Nouveau ID du professeur: ");
	        int professeurID = scanner3.nextInt();

	        System.out.print("Nouvelles heures par semaine: ");
	        int heuresParSemaine = scanner3.nextInt();
	        scanner3.nextLine(); // Consume newline

	        System.out.print("Nouveau semestre: ");
	        String semestre = scanner3.nextLine();

	        System.out.print("Nouveau volume horaire total: ");
	        int volumeHoraireTotal = scanner3.nextInt();
	        scanner3.nextLine(); // Consume newline
	        
	        Course course = new Course(coursID, nomCours, codeCours, professeurID, heuresParSemaine, semestre, volumeHoraireTotal);
	        courseDAO.updateCourse(course);
	        System.out.println("Cours mis � jour avec succ�s.");
	    }
	    private static void deleteCourse(Scanner scanner3, CourseDAO courseDAO) throws Exception {
	        System.out.print("Entrez l'ID du cours � supprimer: ");
	        int coursID = scanner3.nextInt();
	        scanner3.nextLine(); // Consume newline
	        
	        courseDAO.deleteCourse(coursID);
	        System.out.println("Cours supprim� avec succ�s.");
	    }




	    // Implementations for addCourse, viewCourse, viewAllCourses, updateCourse, deleteCourse
	    // Similar to the addCourse example provided earlier

	//################
	    private static void manageMatieres(Scanner scanner2, MatiereDAO matiereDAO) throws Exception {
	        while (true) {
	            System.out.println("\nGestion des Mati�res:");
	            System.out.println("1. Ajouter une mati�re");
	            System.out.println("2. Voir une mati�re par ID");
	            System.out.println("3. Voir toutes les mati�res");
	            System.out.println("4. Mettre � jour une mati�re");
	            System.out.println("5. Supprimer une mati�re");
	            System.out.println("6. Quitter");
	            System.out.print("Entrez votre choix: ");
	            int choice = scanner2.nextInt();
	            scanner2.nextLine(); // Consommer la ligne restante

	            switch (choice) {
	                case 1:
	                    addMatiere(scanner2, matiereDAO);
	                    break;
	                case 2:
	                    viewMatiere(scanner2, matiereDAO);
	                    break;
	                case 3:
	                    viewAllMatieres(matiereDAO);
	                    break;
	                case 4:
	                    updateMatiere(scanner2, matiereDAO);
	                    break;
	                case 5:
	                    deleteMatiere(scanner2, matiereDAO);
	                    break;
	                case 6:
	                    System.out.println("Au revoir !");
	                    return; // Quitter
	                default:
	                    System.out.println("Choix non valide. Veuillez r�essayer.");
	            }
	        }
	    }

	    private static void addMatiere(Scanner scanner2, MatiereDAO matiereDAO) throws Exception {
	        System.out.print("Nom de la mati�re: ");
	        String nom = scanner2.nextLine().trim(); // Trim input to remove leading/trailing spaces

	        System.out.print("ID du cours associ�: ");
	        int coursID = scanner2.nextInt();
	        scanner2.nextLine(); // Consume newline left-over after reading int

	        // Create a new Matiere object without specifying MatiereID, as it's auto-generated
	        Matiere matiere = new Matiere(0, nom, coursID); // Use 0 or another placeholder for MatiereID
	        matiereDAO.addMatiere(matiere);
	        System.out.println("Mati�re ajout�e avec succ�s.");
	    }


	    private static void viewMatiere(Scanner scanner, MatiereDAO matiereDAO) throws Exception {
	        System.out.print("Entrez l'ID de la mati�re � voir: ");
	        int id = scanner.nextInt();

	        Matiere matiere = matiereDAO.getMatiere(id);
	        if (matiere != null) {
	            System.out.println("Mati�re: ID = " + matiere.getMatiereID() + ", Nom = " + matiere.getNomMatiere() + ", CoursID = " + matiere.getCoursID());
	        } else {
	            System.out.println("Mati�re non trouv�e.");
	        }
	    }

	    private static void viewAllMatieres(MatiereDAO matiereDAO) throws Exception {
	        List<Matiere> matieres = matiereDAO.getAllMatieres();
	        if (matieres.isEmpty()) {
	            System.out.println("Aucune mati�re trouv�e.");
	        } else {
	            matieres.forEach(m -> System.out.println("ID: " + m.getMatiereID() + ", Nom: " + m.getNomMatiere() + ", CoursID: " + m.getCoursID()));
	        }
	    }

	    private static void updateMatiere(Scanner scanner, MatiereDAO matiereDAO) throws Exception {
	        System.out.print("Entrez l'ID de la mati�re � mettre � jour: ");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consommer la ligne restante

	        System.out.print("Nouveau nom de la mati�re: ");
	        String nom = scanner.nextLine();

	        System.out.print("Nouvel ID du cours associ�: ");
	        int coursID = scanner.nextInt();

	        Matiere matiere = new Matiere(id, nom, coursID);
	        matiereDAO.updateMatiere(matiere);
	        System.out.println("Mati�re mise � jour avec succ�s.");
	    }

	    private static void deleteMatiere(Scanner scanner, MatiereDAO matiereDAO) throws Exception {
	        System.out.print("Entrez l'ID de la mati�re � supprimer: ");
	        int id = scanner.nextInt();

	        matiereDAO.deleteMatiere(id);
	        System.out.println("Mati�re supprim�e avec succ�s.");
	    }

	    private static void manageProfesseurs(Scanner scanner1, ProfesseurDAO professeurDAO) throws Exception {
            while (true) {
                System.out.println("\nMenu de Gestion des Professeurs:");
                System.out.println("1. Ajouter un professeur");
                System.out.println("2. Voir un professeur par ID");
                System.out.println("3. Voir tous les professeurs");
                System.out.println("4. Mettre � jour un professeur");
                System.out.println("5. Supprimer un professeur");
                System.out.println("6. Quitter");
                System.out.print("Entrez votre choix: ");
                int choice = scanner1.nextInt();

                switch (choice) {
                    case 1:
                        // Ajouter un professeur
                        addProfesseur(scanner1, professeurDAO);
                        break;
                    case 2:
                        // Voir un professeur par ID
                        viewProfesseur(scanner1, professeurDAO);
                        break;
                    case 3:
                        // Voir tous les professeurs
                        viewAllProfesseurs(professeurDAO);
                        break;
                    case 4:
                        // Mettre � jour un professeur
                        updateProfesseur(scanner1, professeurDAO);
                        break;
                    case 5:
                        // Supprimer un professeur
                        deleteProfesseur(scanner1, professeurDAO);
                        break;
                    case 6:
                        // Quitter
                        System.out.println("Au revoir !");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Choix non valide. Veuillez r�essayer.");
                }
            }
        } 


    private static void addProfesseur(Scanner scanner, ProfesseurDAO professeurDAO) throws Exception {
        System.out.print("Entrez l'ID du professeur: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante
        
        System.out.print("Entrez le nom du professeur: ");
        String nom = scanner.nextLine();
        
        System.out.print("Entrez le pr�nom du professeur: ");
        String prenom = scanner.nextLine();
        
        System.out.print("Entrez l'email du professeur: ");
        String email = scanner.nextLine();
        
        System.out.print("Entrez l'ID du d�partement: ");
        int departementID = scanner.nextInt();
        
        Professeur professeur = new Professeur(id, nom, prenom, email, departementID);
        professeurDAO.addProfesseur(professeur);
        System.out.println("Professeur ajout� avec succ�s.");
    }

    private static void viewProfesseur(Scanner scanner, ProfesseurDAO professeurDAO) throws Exception {
        System.out.print("Entrez l'ID du professeur � voir: ");
        int id = scanner.nextInt();
        Professeur professeur = professeurDAO.getProfesseur(id);
        System.out.println(professeur != null ? professeur : "Professeur non trouv�.");
    }

    private static void viewAllProfesseurs(ProfesseurDAO professeurDAO) throws Exception {
        List<Professeur> professeurs = professeurDAO.getAllProfesseurs();
        professeurs.forEach(System.out::println);
    }

    private static void updateProfesseur(Scanner scanner, ProfesseurDAO professeurDAO) throws Exception {
        System.out.print("Entrez l'ID du professeur � mettre � jour: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consommer la ligne restante

        System.out.print("Nouveau nom: ");
        String nom = scanner.nextLine();

        System.out.print("Nouveau pr�nom: ");
        String prenom = scanner.nextLine();

        System.out.print("Nouvel email: ");
        String email = scanner.nextLine();

        System.out.print("Nouvel ID de d�partement: ");
        int departementID = scanner.nextInt();

        Professeur professeur = new Professeur(id, nom, prenom, email, departementID);
        professeurDAO.updateProfesseur(professeur);
        System.out.println("Professeur mis � jour avec succ�s.");
    }

    private static void deleteProfesseur(Scanner scanner, ProfesseurDAO professeurDAO) throws Exception {
        System.out.print("Entrez l'ID du professeur � supprimer: ");
        int id = scanner.nextInt();

        professeurDAO.deleteProfesseur(id);
        System.out.println("Professeur supprim� avec succ�s.");
    }

	    //###########
    private static void manageSemestres(Scanner scanner, SemestreDAO semestreDAO) throws Exception {
        while (true) {
            System.out.println("\nGestion des Semestres:");
            System.out.println("1. Ajouter un semestre");
            System.out.println("2. Voir un semestre");
            System.out.println("3. Voir tous les semestres");
            System.out.println("4. Mettre � jour un semestre");
            System.out.println("5. Supprimer un semestre");
            System.out.println("6. Retour");
            System.out.print("Choisissez une option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addSemestre(scanner, semestreDAO);
                    break;
                case 2:
                    viewSemestre(scanner, semestreDAO);
                    break;
                case 3:
                    viewAllSemestres(semestreDAO);
                    break;
                case 4:
                    updateSemestre(scanner, semestreDAO);
                    break;
                case 5:
                    deleteSemestre(scanner, semestreDAO);
                    break;
                case 6:
                    return; // Retour au menu principal
                default:
                    System.out.println("Choix non valide. Veuillez r�essayer.");
            }
        }
    }
            private static void addSemestre(Scanner scanner, SemestreDAO semestreDAO) throws Exception {
            	 System.out.print("Entrez l'ID du semestre: ");
                 int id1 = scanner.nextInt();
                 scanner.nextLine();
                System.out.print("Entrez le nom du semestre: ");
                scanner.nextLine(); // Consommer la nouvelle ligne
                String nomSemestre = scanner.nextLine();
                System.out.print("Entrez le nombre de semaines: ");
                int nombreDeSemaines = scanner.nextInt();
                Semestre semestre = new Semestre(id1, nomSemestre, nombreDeSemaines);
                
              
                semestreDAO.addSemestre(semestre);
                System.out.println("Semestre ajout� avec succ�s.");
            }

            private static void viewSemestre(Scanner scanner, SemestreDAO semestreDAO) throws Exception {
                System.out.print("Entrez l'ID du semestre � voir: ");
                int semestreID = scanner.nextInt();
                
                Semestre semestre = semestreDAO.getSemestre(semestreID);
                System.out.println(semestre != null ? semestre : "Semestre non trouv�.");
            }

            private static void viewAllSemestres(SemestreDAO semestreDAO) throws Exception {
                List<Semestre> semestres = semestreDAO.getAllSemestres();
                semestres.forEach(System.out::println);
            }

            private static void updateSemestre(Scanner scanner, SemestreDAO semestreDAO) throws Exception {
                System.out.print("Entrez l'ID du semestre � mettre � jour: ");
                int semestreID = scanner.nextInt();
                scanner.nextLine(); // Consommer la nouvelle ligne
                
                System.out.print("Nouveau nom du semestre: ");
                String nomSemestre = scanner.nextLine();
                
                System.out.print("Nouveau nombre de semaines: ");
                int nombreDeSemaines = scanner.nextInt();
                
                Semestre semestre = new Semestre(semestreID, nomSemestre, nombreDeSemaines);
                semestreDAO.updateSemestre(semestre);
                System.out.println("Semestre mis � jour avec succ�s.");
            }

            private static void deleteSemestre(Scanner scanner, SemestreDAO semestreDAO) throws Exception {
                System.out.print("Entrez l'ID du semestre � supprimer: ");
                int semestreID = scanner.nextInt();
                
                semestreDAO.deleteSemestre(semestreID);
                System.out.println("Semestre supprim� avec succ�s.");
        }
	    }

	


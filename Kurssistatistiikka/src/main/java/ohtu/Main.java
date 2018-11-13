package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        
        String url2 = "https://studies.cs.helsinki.fi/courses/courseinfo";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
        
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();


        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        CourseInfo[] ci = mapper.fromJson(bodyText2, CourseInfo[].class);
        
        System.out.println("opiskelijanumero "+studentNr+"\n");
        for (CourseInfo course : ci) { 
            int tasksDone = 0;
            int totalTime = 0;
            for (Submission submission : subs) {
                    if(submission.getCourse().equals(course.getName())){
                        System.out.println(course.getFullName());                      
                        System.out.println("viikko " +submission.getWeek()+":\n\t tehtyjä tehtäviä " +submission.getExercises().size()+ "/" +course.getExercises(submission.getWeek())+ " aikaa kului " +submission.getHours()+ " tehdyt tehtävät: " +submission.getExercises().toString().replace("[","").replace("]","")+"\n"); 
                        tasksDone += submission.exercisesDone();
                        totalTime += submission.getHours();             
                    }  
            }
            if(totalTime !=0){
            System.out.println("yhteensä " +tasksDone+ "/" +course.getTotalExercises()+ " tehtävää " +totalTime+ " tuntia \n");
            }
        }      
    }
}
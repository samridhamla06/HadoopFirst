import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;

public class MainClass {

    public static void main(String[] args){

        try{

            Configuration conf= new Configuration();
            Job job = new Job(conf,"My Word Count Program");
            job.setJarByClass(MainClass.class);
            job.setMapperClass(MyMapper.class);
            job.setReducerClass(MyReducer.class);
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(IntWritable.class);
            job.setInputFormatClass(TextInputFormat.class);
            job.setOutputFormatClass(TextOutputFormat.class);
//Configuring the input/output path from the filesystem into the job
            FileInputFormat.addInputPath(job, new Path(args[0]));
            FileOutputFormat.setOutputPath(job, new Path(args[1]));



//deleting the output path automatically from hdfs so that we don't have to delete it explicitly
            //outputPath.getFileSystem(conf).delete(outputPath);
//exiting the job only if the flag value becomes false

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

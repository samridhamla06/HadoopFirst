import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;


public class MyMapper extends Mapper<LongWritable, Text, Text, IntWritable> {


    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        super.map(key, value, context);

        StringTokenizer stringTokenizer = new StringTokenizer(value.toString());
        Text word;
        while(stringTokenizer.hasMoreTokens()){
            word = new Text(stringTokenizer.nextToken());
            context.write(word,new IntWritable(1));

        }

    }
}

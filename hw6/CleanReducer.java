import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CleanReducer extends Reducer<NullWritable, Text, NullWritable, Text> {
    @Override
    protected void reduce(NullWritable key, Iterable<Text> values, Context context) 
            throws IOException, InterruptedException {
        // Simply emit every value (row) as-is
        for (Text value : values) {
            context.write(NullWritable.get(), value);
        }
    }
}

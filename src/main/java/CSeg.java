/**
 * Chinese segmentation tool for plaintext UTF-8 corpus.
 *
 *
 * ADAPTED from the following:
 *  - http://www.cnblogs.com/wowarsenal/p/3293586.html 
 *  - https://raw.githubusercontent.com/ansjsun/ansj_seg/master/src/test/java/org/ansj/demo/FileDemo.java
 *
 * @author William Yeh
 * @date   2014-07-15
 *
 *--- License statement:

   Copyright 2014  William Yeh <william.pjyeh@gmail.com>

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.



 *---
 */

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.nlpcn.commons.lang.util.IOUtil;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

public class CSeg {
    
    private static String input_filename, output_filename;
    
    public static void main(String[] args) {
        process_cmdline(args);

        BufferedReader reader = null;
        PrintWriter pw = null;

        try {
            reader = IOUtil.getReader(input_filename, "UTF-8") ;
            pw = new PrintWriter(new OutputStreamWriter(
                    new FileOutputStream(output_filename), "UTF-8"), true);

            long start = System.currentTimeMillis();
            int allCount =0 ;
            int termcnt = 0;

            Set<String> set = new HashSet<String>();
            String temp;
            while ((temp = reader.readLine()) != null) {
                String content = temp.trim();
                if (content.length() <= 0)  continue;
                 
                allCount += content.length();
                List<Term> result = ToAnalysis.parse(content);
                for (Term term : result) {
                    String item = term.getName().trim();
                    if (item.length() > 0) {
                        ++termcnt;
                        pw.print(item.trim() + " ");
                        set.add(item);
                    }
                }
                pw.println();
            }
            
            long end = System.currentTimeMillis() ;
            System.out.println("# of terms: " + termcnt + "\n" 
                + "# of unique terms: " + set.size() + "\n"
                + "# of characters: " + allCount + "\n"
                + "Chars/sec: " + (allCount * 1000.0 / (end - start)));
        }
        catch (IOException e) { 
            e.printStackTrace();
        }
        finally {
            if (null != reader) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != pw) {
                pw.close();
            }
        }
    }



    public static void process_cmdline(String[] args) {
        if (args.length < 2) {
            usage();
            System.exit(1);
        }

        input_filename  = args[0];
        output_filename = args[1];
    }


    public static void usage() {
        System.err.println("Usage:");
        System.err.println("  $ java -cp cseg-all.jar  CSeg  input_file  output_file");
    }

}
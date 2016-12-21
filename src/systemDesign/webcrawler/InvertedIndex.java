package systemDesign.webcrawler;

/*
Create an inverted index with given documents.

 Notice

Ensure that data does not include punctuation.

Have you met this question in a real interview? Yes
Example
Given a list of documents with id and content. (class Document)

[
  {
    "id": 1,
    "content": "This is the content of document 1 it is very short"
  },
  {
    "id": 2,
    "content": "This is the content of document 2 it is very long bilabial bilabial heheh hahaha ..."
  },
]
Return an inverted index (HashMap with key is the word and value is a list of document ids).

{
   "This": [1, 2],
   "is": [1, 2],
   ...
}
 * */

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */

public class InvertedIndex {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> results = new HashMap<String, List<Integer>>();
        for (Document doc : docs) {
            int id = doc.id;
            StringBuffer temp = new StringBuffer("");
            String content = doc.content;
            int n = content.length();
            for (int i = 0; i < n; ++i) {
                if (content.charAt(i) == ' ') {
                    insert(results, temp.toString(), id);
                    temp = new StringBuffer("");
                } else
                    temp.append(content.charAt(i));
            }
            insert(results, temp.toString(), id);
        }
        return results;
    }

    public void insert(Map<String, List<Integer>> rt, String tmp, int id) {
        if (tmp.equals("") || tmp == null)
            return;
        if (!rt.containsKey(tmp))
            rt.put(tmp, new ArrayList<Integer>());
        
        int n = rt.get(tmp).size();
        if (n == 0 || rt.get(tmp).get(n - 1) != id)
            rt.get(tmp).add(id);
    }
}

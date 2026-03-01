import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static class Music {
        int id;
        int play;
        String genre;

        Music(int id, int play, String genre) {
            this.id = id;
            this.play = play;
            this.genre = genre;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlaySum = new HashMap<>();
        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            genrePlaySum.put(genres[i], genrePlaySum.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(i, plays[i], genres[i]));
        }

        List<String> sortedGenres = genrePlaySum.keySet().stream()
                .sorted((a, b) -> genrePlaySum.get(b) - genrePlaySum.get(a))
                .collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (String g : sortedGenres) {
            List<Music> filtered = musicList.stream()
                    .filter(m -> m.genre.equals(g))
                    .sorted((m1, m2) -> {
                        if (m1.play != m2.play) return m2.play - m1.play;
                    })
                    .limit(2) // 최대 2개
                    .collect(Collectors.toList());
            for (Music m : filtered) {
                result.add(m.id);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
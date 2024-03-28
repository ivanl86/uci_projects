package labs.lab10;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NetflixTitlesStats {

	/**
	 * Given a Stream of NetflixTitles, returns the number of titles in the Stream
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the number of titles in the Stream
	 */
	public static long problem1_countTitles(Stream<NetflixTitle> titles) {
		return titles.count(); // FIX ME
	}
	
	
	/**
	 * Counts how many titles were made in a time frame, given an (inclusive) range of 
	 * years
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param minYear	lower bound of the range of years (inclusive)
	 * @param maxYear	upper bound of the range of years (inclusive)
	 * 
	 * @return	number of NetflixTitles released in the time frame
	 */
	public static long problem2_countTitlesReleasedInYears(Stream<NetflixTitle> titles,
			int minYear, int maxYear) {
		return titles.filter(title -> title.getReleaseYear() >= minYear &&
										title.getReleaseYear() <= maxYear)
						.count(); // FIX ME
	}
	
	
	/**
	 * Groups titles by their age certification. Returns a Map<String, List<String>> that maps 
	 * age certifications to a list of titles with that age certification.
	 * 
	 * The map should be sorted in ascending order of age certification.
	 * 
	 * If the stream is empty, returns an empty map.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	a Map<String, List<String>> that maps age certifications to a list of titles with that age certification
	 */
	public static Map<String, List<String>> problem3_getTitlesGroupedByAgeCertification(Stream<NetflixTitle> titles) {
		return titles.collect(Collectors.groupingBy(NetflixTitle::getAgeCertification,
													TreeMap::new,
													Collectors.mapping(NetflixTitle::getTitle,
															Collectors.toList()))); // FIX ME
	}
	
	
	/**
	 * Counts how many distinct production countries are represented in the given Stream of
	 * NetflixTitles (do not count blanks)
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the number of distinct production countries in the given stream of NetflixTitles
	 */
	public static long problem4_countProductionCountries(Stream<NetflixTitle> titles) {
		return titles.flatMap(title -> title.getProductionCountries().stream())
						.filter(country -> !country.isEmpty())
						.distinct()
						.count(); // FIX ME
	}
	
	
	/**
	 * Given a Stream of NetflixTitles, returns a comma-separated string of all 
	 * the different age certifications in the stream, sorted in ascending 
	 * lexicographic order
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	a comma-separated string of all the different age certfications in 
	 * the stream, sorted in ascending lexicographic order
	 */
	public static String problem5_getAgeCertifications(Stream<NetflixTitle> titles) {
		return titles.map(NetflixTitle::getAgeCertification)
						.filter(cert -> !cert.isEmpty())
						.distinct()
						.sorted()
						.collect(Collectors.joining(", ")); // FIX ME
	}
	
	/**
	 * Returns the most popular title (based on IMDB votes) in the given genre
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param genre		genre 
	 * 
	 * @return	the most popular title (based on IMDB votes) in the given genre
	 */
	public static Optional<NetflixTitle> problem6_getMostPopularTitleInGenre(Stream<NetflixTitle> titles,
			String genre) {
		return titles.filter(title -> title.getGenres()
						.contains(genre))
						.max(Comparator.comparingInt(NetflixTitle::getImdbVotes)); // FIX ME
	}
	
	
	/**
	 * Returns the average imdb score of NetflixTitles in the stream
	 * 
	 * @param titles	input stream of NetflixTitles
	 * 
	 * @return	the average imdb score of NetflixTitles in the stream
	 */
	public static double problem7_getAverageIMDBScore(Stream<NetflixTitle> titles) {
		return titles.mapToDouble(NetflixTitle::getImdbScore)
						.average()
						.orElse(0.0); // FIX ME
	}
	
	
	/**
	 * Counts how many titles of a given type (SHOW or MOVIE) are in each genre.
	 * Grabs all titles from the stream of the given type, and groups
	 * them by genre. Returns a Map<String, Long> that maps genres to the number
	 * of titles of the given type in that genre
	 * 
	 * This map should be sorted in ascending order of genre.
	 * 
	 * If the stream is empty, returns an empty map.
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param type		type of title to consider (SHOW or MOVIE)
	 * 
	 * @return	a Map<String, Long> that maps genres to the number
	 * of titles of the given type in that genre
	 */
	public static Map<String, Long> problem8_countTitlesByGenre(Stream<NetflixTitle> titles,
			String type) {
		return titles.filter(title -> title.getType().toString().equals(type))
						.flatMap(title -> title.getGenres().stream())
						.collect(Collectors.groupingBy(Function.identity(),
														TreeMap::new,
														Collectors.counting())); // FIX ME
	}
	
	
	/**
	 * Given a Stream of NetflixTitles and the name of a country, returns a list of 
	 * NetflixTitles produced by that country, sorted in ascending lexicographic
	 * order by title
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param country	country to search for
	 * 
	 * @return	a list of NetflixTitles produced by that country, sorted in 
	 * ascending lexicographic order by title
	 */
	public static List<NetflixTitle> problem9_getTitlesProducedInCountry(Stream<NetflixTitle> titles,
			String country) {
		return titles.filter(title -> title.getProductionCountries().contains(country))
						.sorted(Comparator.comparing(NetflixTitle::getTitle))
						.collect(Collectors.toList()); // FIX ME
	}
	
	
	/**
	 * Calculates what percentage of the titles in the stream are of the given type (SHOW or MOVIE)
	 * 
	 * @param titles	input stream of NetflixTitles
	 * @param type		type to calculate
	 * 
	 * @return	percentage of the titles in the stream are of the given type
	 */
	public static double problem10_getPercentageOfType(Stream<NetflixTitle> titles, String type) {
		List<NetflixTitle> titleList = titles.toList();
		long typeCount = titleList.stream()
									.filter(title -> title.getType()
															.toString()
															.equals(type))
									.count();
		return titleList.size() > 0 ? (double) typeCount / titleList.size() * 100 : 0.0;
	}
}


import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

enum City{
	 //0. New York - 1. Los Angeles - 2. Chicago - 3. Minneapolis - 4. Denver - 5. Dallas - 6. Seattle - 7. Boston - 8. San Francisco - 9. St. Louis - 10. Houston - 11. Phoenix - 12. Salt Lake City
	 NEW_YORK,
	 LOS_ANGELES,
	 CHICAGO,
	 MINNEAPOLIS,
	 DENVER,
	 DALLAS,
	 SEATTLE,
	 BOSTON,
	 SAN_FRANCISCO,
	 ST_LOUIS,
	 HOUSTON,
	 PHOENIX,
	 SALT_LAKE_CITY
}

class DistanceMatrix{
	 int[][] graph = 
         {
        {0, 2451, 713, 1018, 1631, 1374, 2408, 213, 2571, 875, 1420, 2145, 1972},
        {2451, 0, 1745, 1524, 831, 1240, 959, 2596, 403, 1589, 1374, 357, 579},
        {713, 1745, 0, 355, 920, 803, 1737, 851, 1858, 262, 940, 1453, 1260},
        {1018, 1524, 355, 0, 700, 862, 1395, 1123, 1584, 466, 1056, 1280, 987},
        {1631, 831, 920, 700, 0, 663, 1021, 1769, 949, 796, 879, 586, 371},
        {1374, 1240, 803, 862, 663, 0, 1681, 1551, 1765, 547, 225, 887, 999},
        {2408, 959, 1737, 1395, 1021, 1681, 0, 2493, 678, 1724, 1891, 1114, 701},
        {213, 2596, 851, 1123, 1769, 1551, 2493, 0, 2699, 1038, 1605, 2300, 2099},
        {2571, 403, 1858, 1584, 949, 1765, 678, 2699, 0, 1744, 1645, 653, 600},
        {875, 1589, 262, 466, 796, 547, 1724, 1038, 1744, 0, 679, 1272, 1162},
        {1420, 1374, 940, 1056, 879, 225, 1891, 1605, 1645, 679, 0, 1017, 1200},
        {2145, 357, 1453, 1280, 586, 887, 1114, 2300, 653, 1272, 1017, 0, 504},
        {1972, 579, 1260, 987, 371, 999, 701, 2099, 600, 1162, 1200, 504, 0},  
        };       
	 int n = 13;
	 
	 public int distance(City from,City to) {
		 return graph[from.ordinal()][to.ordinal()];
	 }
	 public int distance(int from,int to) {
		 return graph[from][to];
	 }
}
class Route{
	private int[] route;
	private double distance = 0;
	private double fitness = -1;
	DistanceMatrix distanceMatrix = new DistanceMatrix();
	
	public Route(int chromosomeLength) {
		// Create individualchromosome
		int offspringChromosome[] = new int[chromosomeLength];
        Arrays.fill(offspringChromosome, -1);
        this.route = offspringChromosome;
	}
	public void Initialize() {
		for (int gene = 0; gene < route.length; gene++) {
			route[gene] = gene;
		}
	}
	public void setCity(int offset, int gene) {
		this.route[offset] = gene;
	}
	public int getCity(int offset) {
		return this.route[offset];
	}
	public String toString() {
		String output = "";
		for (int city = 0; city < this.route.length; city++) {
			output += this.route[city] + ",";
		}
		return output;
	}
	public boolean containsCity(int gene) {
		for (int i = 0; i < this.route.length; i++) {
			if (this.route[i] == gene) {
				return true;
			}
		}
		return false;
	}
	public double getDistance() {
		if (this.distance > 0) {
			return this.distance;
		}
		// Loop over cities in route and calculate route distance
		double totalDistance = 0;
		for (int cityIndex = 0; cityIndex + 1 < this.route.length; cityIndex++) {
			totalDistance += distanceMatrix.distance(cityIndex, cityIndex + 1);
		}
		totalDistance += distanceMatrix.distance(this.route.length - 1, 0);
		this.distance = totalDistance;

		return totalDistance;
	}
	 public double getFitness(){
	       if( fitness == -1)
	    	   fitness = 1 / getDistance();
	        return fitness;
	}
	 public int size() {
			return this.route.length;
		}
}
class Population{
	private Route population[];
	private double avgFitness = -1;
	
	public Population(int populationSize) {
		// Initial population
		this.population = new Route[populationSize];
	}
	public Population(int populationSize, int chromosomeLength) {
		// Initial population
		this.population = new Route[populationSize];

		// Loop over population size
		for (int chromosomeCount = 0; chromosomeCount < populationSize; chromosomeCount++) {
			// Create individual
			Route route = new Route(chromosomeLength);
			route.Initialize();
			// Add individual to population
			this.population[chromosomeCount] = route;
		}
	}
	public Route setRoute(int offset, Route route) {
		return population[offset] = route;
	}
	public Route getFittest(int offset) {
		// Order population by fitness
		Arrays.sort(this.population, new Comparator<Route>() {
			@Override
			public int compare(Route o1, Route o2) {
				if (o1.getFitness() > o2.getFitness()) {
					return -1;
				} else if (o1.getFitness() < o2.getFitness()) {
					return 1;
				}
				return 0;
			}
		});

		// Return the fittest individual
		return this.population[offset];
	}
	public void evalPopulation(){
        double populationFitness = 0;
        // Loop over population evaluating individuals and summing population fitness
        for (Route route : population) {
            populationFitness += route.getFitness();
        }
        avgFitness = populationFitness / population.length;
    }
	public Route selectParent() {
		int tournamentSize=5;
		shuffle();
		Population tournament = new Population(tournamentSize);
		for (int i = 0; i < tournamentSize; i++) {
			tournament.population[i]= population[i];
		}
		return tournament.getFittest(0);
	}
	public void shuffle() {
		Random rnd = new Random();
		for (int i = population.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Route route = population[index];
			population[index] = population[i];
			population[i] = route;
		}
	}
	public int size() {
		return this.population.length;
	}
}
interface CrossOverStatergy{
	 Population crossoverPopulation(Population population);
}
interface MutationStatergy{
	Population mutatePopulation(Population population);
}
class CrossOverStategryImpl implements CrossOverStatergy{
	  private double mutationRate=0.001;
	 private double crossoverRate=0.9;
	 private int elitismCount=2;
	 protected int tournamentSize=5;
	public Population crossoverPopulation(Population population){
	        // Create new population
	        Population newPopulation = new Population(population.size());
	        
	        // Loop over current population by fitness
	        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
	            // Get parent1
	            Route parent1 = population.getFittest(populationIndex);
	            if(populationIndex < this.elitismCount || this.crossoverRate <= Math.random())
	            {
	            	 // Add individual to new population without applying crossover
	                newPopulation.setRoute(populationIndex, parent1);
	                continue;
	            }
	            
	            // Find parent2 with tournament selection
	            Route parent2 = population.selectParent();
	            Route offspring= createOffSpring(parent1,parent2);
	            // Add child
	            newPopulation.setRoute(populationIndex, offspring);      
	        }
	        return newPopulation;
	    }
	 public Route createOffSpring(Route parent1 ,Route parent2 ) {
	    	// Create blank offspring chromosome
	        Route offspring = new Route(parent1.size());
	    	// Get subset of parent chromosomes
         int substrPos1 = (int) (Math.random() * parent1.size());
         int substrPos2 = (int) (Math.random() * parent1.size());

         // make the smaller the start and the larger the end
         final int startSubstr = Math.min(substrPos1, substrPos2);
         final int endSubstr = Math.max(substrPos1, substrPos2);

         // Loop and add the sub tour from parent1 to our child
         for (int i = startSubstr; i < endSubstr; i++) {
             offspring.setCity(i, parent1.getCity(i));
         }
         // Loop through parent2's city tour
         for (int i = 0; i < parent2.size(); i++) {
              int parent2City = i + endSubstr;
                 if (parent2City >= parent2.size()) {
                 	parent2City -= parent2.size();
                 }

                 // If offspring doesn't have the city add it
                 if (offspring.containsCity(parent2.getCity(parent2City)) == false) {
                     // Loop to find a spare position in the child's tour
                     for (int ii = 0; ii < offspring.size(); ii++) {
                         // Spare position found, add city
                         if (offspring.getCity(ii) == -1) {
                             offspring.setCity(ii, parent2.getCity(parent2City));
                             break;
                         }
                     }
                 }
         }
         return offspring;
	 	}
	
}
class MutationStatergyIMpl implements MutationStatergy{
	 private double mutationRate=0.001;
	 private double crossoverRate=0.9;
	 private int elitismCount=2;
	 protected int tournamentSize=5;
	public Population mutatePopulation(Population population){
        // Initialize new population
        Population newPopulation = new Population(population.size());
        
        // Loop over current population by fitness
        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Route route = population.getFittest(populationIndex);

            // Skip mutation if this is an elite individual
            if (populationIndex >= this.elitismCount) {   
            	// System.out.println("Mutating population member "+populationIndex);
                // Loop over individual's genes
                for (int geneIndex = 0; geneIndex < route.size(); geneIndex++) {   
                	// System.out.println("\tGene index "+geneIndex);
                    // Does this gene need mutation?
                    if (this.mutationRate > Math.random()) {
                        // Get new gene position
                        int newGenePos = (int) (Math.random() * route.size());
                        // Get genes to swap
                        int gene1 = route.getCity(newGenePos);
                        int gene2 = route.getCity(geneIndex);
                        // Swap genes
                        route.setCity(geneIndex, gene1);
                        route.setCity(newGenePos, gene2);
                    }
                }
            }
            
            // Add individual to population
            newPopulation.setRoute(populationIndex, route);
        }
        
        // Return mutated population
        return newPopulation;
    }
}
class Controller {
	 CrossOverStatergy crossOverStatergy;
	 MutationStatergy mutationStatergy;
	 public Controller( CrossOverStatergy crossOverStatergy,  MutationStatergy mutationStatergy){
		 this.crossOverStatergy = crossOverStatergy;
		 this.mutationStatergy = mutationStatergy;
	 }
	public void execute() {
		Population population =new Population(100,13);
		population.evalPopulation();
		// Keep track of current generation
		int generation = 1;
		// Start evolution loop
		while (generation < 100) {
			// Print fittest individual from population
		    Route route =population.getFittest(0);
			System.out.println("G"+generation+" Best distance: " + route.getDistance());
			// Apply crossover
			population = crossOverStatergy.crossoverPopulation(population);
			// Apply mutation
			population = mutationStatergy.mutatePopulation(population);
			// Evaluate population
			population.evalPopulation();
			// Increment the current generation
			generation++;
		}
	}
}

rm -f simulation.txt
find . -name "*.java" > sources.txt
javac @sources.txt
java Main scenario.txt
find . -name "*.class" -delete
rm sources.txt
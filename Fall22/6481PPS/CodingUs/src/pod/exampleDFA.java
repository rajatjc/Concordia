//package pod;
//
//public class exampleDFA {
//    public static Automaton toAutomaton(String pattern) {
//        Automaton automaton = Automaton.makeEmptyString();
//        for (int i = 0; i < pattern.length(); i++) {
//            char p = pattern.charAt(i);
//            switch (p) {
//                case '*':
//                    automaton = automaton.concatenate(Automaton.makeAnyString());
//                    break;
//                case '?':
//                    automaton = automaton.concatenate(Automaton.makeAnyChar());
//                    break;
//                default:
//                    automaton = automaton.concatenate(Automaton.makeChar(p));
//            }
//        }
//        return automaton;
//    }
//    public static void main(String[] args) {
//
//    }
//}

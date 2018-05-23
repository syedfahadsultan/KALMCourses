# Knowledge Authoring Logic Machine (KALM)
Authors: Tiantian Gao, Paul Fodor, Michael Kifer

# Introduction
We propose an approach to knowledge authoring with the aim of endowing domain experts with tools that would allow them to translate their knowledge into logic by means of CNL. We also develop the query service to support question answering based on the authored knowledge. The contributions of this work are five-fold:
(a) A formal, FrameNet-inspired ontology FrameOnt that formalizes FrameNet frames and integrates linguistic resources from BabelNet to represent the meaning of English sentences.
(b) An incrementally-learned semantic parser that disambiguates CNL sentences by mapping semantically equivalent sentences into the same FrameOnt frames and assigns them unique logical representation (ULR). 
(c) Explainability: the approach makes it possible to explain both why particular meanings are assigned and also why mistakes were made.
(d) A hybrid CNL-based language for authoring queries.
(e) Both knowledge authoring and question answering parts achieve superior accuracy.

# Requirements
1. Java 1.8
2. XSB Prolog (http://xsb.sourceforge.net/)
3. XSB Prolog version of ACE Parsing Engine (APE) under LGPL licence (included in this repository)
4. APE Clex under GPL licence (http://attempto.ifi.uzh.ch/site/downloads/files/)
5. BabelNet 3.7.1 Java API. (http://babelnet.org/download)
6. BabelNet 3.7 indices (http://babelnet.org/download)

# Installation
1. BabelNet 3.7 indices. User must request access from http://babelnet.org/download.
2. XSB Prolog (http://xsb.sourceforge.net/).

# Code
* `src/` Java source code for UI, semantic score computation, meta data deserialization for frame property/semantic link override/semantic score parameters/candidate parse results.
* `scripts/` XSB Prolog code for APE engine + candidate frame parses.
* `config/` BabelNet config files (please download from BabelNet website specified in requirement section).
* `lib/` BabelNet lib files (please download from BabelNet website specified in requirement section).
* `resources/jlt/` BabelNet resources files (please download from BabelNet website specified in requirement section). User has to create the directory by hand.
* `resources/wnplusplus/` BabelNet resources files (please download from BabelNet website specified in requirement section). User has to create the directory by hand.
* `resources/batch/batch.txt` A collection of CNL sentences used for batch processing. The default file is the test suite for the system.
* `resources/scores/score.txt` The file containing the frame extraction results. For each sentences, it shows all of the extracted candidate parses with semantic scores, the disambiguated filler-word BabelNet synsets, and semantic paths connecting the filler word to the synset. User has to create the directory by hand. 
* `resources/frame_property/frame_property.txt` The file containing the frame descriptions.
* `resources/semantic_score_meta/` Files containing the weight bias scores, edge penalty scores, and overriden semantic links.
* `testsuite/` Test suite for frame extraction.
* `runxsb.sh` The shell script for running XSB Prolog. User must specify the installation path to XSB Prolog.
* `runbatch.sh` The shell script to process CNL sentences in batch mode.
* `start.sh` The shell script to start the KALM system, the GUI.

# Run
1. GUI: `./start.sh`
2. Bach Mode (Read sentences from file and serialize the frame extraction results into file): `./runbatch.sh`

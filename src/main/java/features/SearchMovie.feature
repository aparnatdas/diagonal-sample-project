@movieSearch @youTubeTests
Feature: Search Movie from YouTube
  As a user, I want to search and play a movie from YouTube

  Background:
#    Given User opens login page

  @MovieSelection
  Scenario: Verify if user is able to search and play a movie
    Given User searches for movie name 'sunflower post malone'
    When User clicks on the movie thumbnail listed
    Then Verifies if the movie is playing
    And User closes the browser
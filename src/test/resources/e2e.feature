Feature: Verify Whether EndToEnd testcases works

  Background: PreSteps to make sure user is on right state
    Given User is already loggedIn with credentials as "akhiljda@gmail.com" and "Password"


  Scenario: Add items to cart successfully
    Given User clicks on Item "Nike react phantom run flyknit 2"
    When User selects the item options size as "X" and color as "Pink"
    And User clicks on AddToCart
#    Then Item should get added to the cart
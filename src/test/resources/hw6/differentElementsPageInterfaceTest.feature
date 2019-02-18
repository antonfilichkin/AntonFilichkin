Feature: Different Elements Page Test

  Test sequence to assert Different Elements page interface functioning as expected.

  Scenario: Login and verify interface functioning as expected
    Given I am on "HOME_PAGE"
    Then Browser title is "HOME_PAGE"

    When I login as user "Piter Chailovskii"
    Then Username in the right-top side of screen is "Piter Chailovskii"
    And Home page have to contain all elements

    When I click on "SERVICE" subcategory in the header
    Then Header dropdown contains options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGES   |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |

    When I click on "SERVICE" subcategory in the left section
    Then Left menu dropdown contains options:
      | SUPPORT            |
      | DATES              |
      | COMPLEX_TABLE      |
      | SIMPLE_TABLE       |
      | USER_TABLE         |
      | TABLE_WITH_PAGES   |
      | DIFFERENT_ELEMENTS |
      | PERFORMANCE        |

    When I open through the header menu "SERVICE" -> "DIFFERENT_ELEMENTS"
    Then Page "DIFFERENT_ELEMENTS_PAGE" is opened
    And Different elements page contains all needed elements
    And Right section is displayed
    And Left section is displayed

    When I set checkboxes "WATER, WIND" to "true"
    Then Checkboxes "WATER, WIND" are checked ("true")
    And There is an individual log for elements:
      | Wind: condition changed to true  |
      | Water: condition changed to true |

    When I select radio	"SELEN"
    Then Metal "SELEN" is checked ("true")
    And There is an individual log for elements:
      | metal: value changed to Selen |

    When I select in dropdown "YELLOW"
    Then Color "YELLOW" is selected
    And There is an individual log for elements:
      | Colors: value changed to Yellow |

    When I set checkboxes "WATER, WIND" to "false"
    Then Checkboxes "WATER, WIND" are unchecked ("false")
    And There is an individual log for elements:
      | Wind: condition changed to false  |
      | Water: condition changed to false |

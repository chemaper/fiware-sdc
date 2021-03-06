# -*- coding: utf-8 -*-
# Copyright 2015 Telefonica Investigación y Desarrollo, S.A.U
#
# This file is part of FIWARE project.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
#
# You may obtain a copy of the License at:
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#
# See the License for the specific language governing permissions and
# limitations under the License.
#
# For those usages not covered by the Apache version 2.0 License please
# contact with opensource@tid.es

__author__ = 'jfernandez'

from commons.terrain_steps import setup_feature, setup_scenario, setup_outline, tear_down
from lettuce import before, after, world


def __clean_test_vars__():
    world.product_name = None
    world.product_release = None
    world.metadatas = None
    world.attributes = None
    world.metadata_key_request = None
    world.metadata_key_value = None
    world.metadata_to_be_updated = None


@before.each_feature
def before_each_feature(feature):
    """ Hook: Will be executed before each feature. Configures global vars and gets token from keystone. """
    setup_feature(feature)


@before.each_scenario
def before_each_scenario(scenario):
    """ Hook: Will be executed before each Scenario. Setup Scenario and initialize World vars """
    setup_scenario(scenario)
    __clean_test_vars__()


@before.outline
def before_outline(param1, param2, param3, param4):
    """ Hook: Will be executed before each Scenario Outline. Same behaviour as 'before_each_scenario'"""
    setup_outline(param1, param2, param3, param4)
    __clean_test_vars__()


@after.all
def after_all(scenario):
    """ Hook: Will be executed after all Scenarios and Features. Removes Feature data and cleans the system  """
    tear_down(scenario)

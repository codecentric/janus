/*
 * Copyright (C) 2012 codecentric AG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.codecentric.janus.atlassian.jira

import com.atlassian.jira.rpc.soap.beans.RemoteGroup
import com.atlassian.jira.rpc.soap.beans.RemoteProject
import com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme
import com.atlassian.jira.rpc.soap.beans.RemoteScheme
import com.atlassian.jira.rpc.soap.beans.RemotePermission
import com.atlassian.jira.rpc.soap.beans.RemoteEntity
import com.atlassian.jira.rpc.soap.beans.RemoteProjectRole
import com.atlassian.jira.rpc.soap.beans.RemoteUser
import com.atlassian.jira.rpc.soap.beans.RemoteRoleActors
import de.codecentric.janus.atlassian.model.RemoteGroupSummary
import de.codecentric.janus.atlassian.model.RemoteProjectSummary
import com.atlassian.jira.rpc.soap.beans.RemoteProjectRoleActors

/**
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
class JiraClient implements JiraSoapClient, JiraRestClient {

    final JiraSession session

    JiraClient(JiraSession session) {
        this.session = session
    }

    @Override
    RemoteGroup getGroup(String groupName) {
        return session.getJiraSoapClient().getGroup(groupName)
    }

    @Override
    void deleteGroup(String groupName) {
        session.getJiraSoapClient().deleteGroup(groupName)
    }

    @Override
    RemoteGroup createGroup(String groupName) {
        return session.getJiraSoapClient().createGroup(groupName)
    }

    @Override
    RemoteProject getProject(String key) {
        return session.getJiraSoapClient().getProject(key)
    }

    @Override
    void deletePermissionScheme(String name) {
        session.getJiraSoapClient().deletePermissionScheme(name)
    }

    @Override
    RemotePermissionScheme[] getPermissionSchemes() {
        return session.getJiraSoapClient().getPermissionSchemes()
    }

    @Override
    RemotePermissionScheme getPermissionScheme(String name) {
        return session.getJiraSoapClient().getPermissionScheme(name);
    }

    @Override
    RemoteScheme[] getNotificationSchemes() {
        return session.getJiraSoapClient().getNotificationSchemes()
    }

    @Override
    RemoteScheme getNotificationScheme(String name) {
        return session.getJiraSoapClient().getNotificationScheme(name)
    }

    @Override
    RemotePermissionScheme createPermissionScheme(String name) {
        return session.getJiraSoapClient().createPermissionScheme(name)
    }

    @Override
    RemotePermissionScheme addPermissionTo(RemotePermissionScheme scheme,
                                           RemotePermission permission,
                                           RemoteEntity entity) {
        return session.getJiraSoapClient().addPermissionTo(scheme, permission,
                entity)
    }

    @Override
    void deleteProject(String projectKey) {
        session.getJiraSoapClient().deleteProject(projectKey)
    }

    @Override
    RemoteProject createProject(RemoteProject project) {
        return session.getJiraSoapClient().createProject(project)
    }

    @Override
    RemoteProjectRole[] getProjectRoles() {
        return session.getJiraSoapClient().getProjectRoles()
    }

    @Override
    RemoteProjectRole getProjectRole(String name) {
        return session.getJiraSoapClient().getProjectRole(name)
    }

    @Override
    RemoteUser createUser(String username, String password, String fullName,
                          String email) {
        return session.getJiraSoapClient().createUser(username, password,
                fullName, email)
    }

    @Override
    void deleteUser(String username) {
        session.getJiraSoapClient().deleteUser(username)
    }

    @Override
    void addUserToGroup(RemoteGroup group, RemoteUser user) {
        session.getJiraSoapClient().addUserToGroup(group, user)
    }

    @Override
    void addGroupToRole(RemoteProject project, RemoteGroup group,
                        RemoteProjectRole role) {
        session.getJiraSoapClient().addGroupToRole(project, group, role)
    }

    @Override
    RemoteRoleActors getDefaultRoleActors(RemoteProjectRole role) {
        return session.getJiraSoapClient().getDefaultRoleActors(role)
    }

    @Override
    RemoteProjectRoleActors getProjectRoleActors(RemoteProject project,
                                                 RemoteProjectRole role) {
        return session.getJiraSoapClient().getProjectRoleActors(project, role)
    }

    @Override
    RemoteGroupSummary[] searchGroups(String query) {
        return session.getJiraRestClient().searchGroups(query)
    }

    @Override
    RemoteProjectSummary[] getProjects() {
        return session.getJiraRestClient().getProjects()
    }

    @Override
    RemoteUser[] searchUser(String name) {
        return session.getJiraRestClient().searchUser(name)
    }
}
